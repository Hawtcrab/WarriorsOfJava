package game;

import game.gameactions.GameAction;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class GUI extends JFrame {

    private JTextArea textPane;
    private JTextPane titlePane;
    private JLabel bg;


    public GUI () {
        super("Essen bei Nacht");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(850,500);
        this.setResizable(false);
        this.setBackground(Color.DARK_GRAY);
        setLayout(null);
        initializeElements();
    }

    private void initializeElements() {
        // Create a JLayeredPane to manage component layers
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(0, 0, 850, 500);
        add(layeredPane);

        // Load the background image
        var image = this.getClass().getResource("/game/bg/ubahn.png");
        try {
            BufferedImage wPic = ImageIO.read(image);
            JLabel bgLabel = new JLabel(new ImageIcon(wPic));
            bgLabel.setBounds(200, 10, 600, 400);
            layeredPane.add(bgLabel, Integer.valueOf(0));
            this.bg = bgLabel;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        var screen = new JTextArea();
        screen.setEditable(false);
        screen.setLineWrap(true);
        screen.setWrapStyleWord(true);
        screen.setForeground(Color.WHITE);
        screen.setOpaque(false);



        JScrollPane scrollPane = new JScrollPane(screen);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBounds(200, 10, 600, 400);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        layeredPane.add(scrollPane, Integer.valueOf(1));
        this.textPane = screen;
        textPane.setFont(new Font("Arial", Font.PLAIN, 16));


        titlePane = new JTextPane();
        titlePane.setBounds(200, 420, 600, 40);
        titlePane.setBorder(BorderFactory.createEtchedBorder());
        titlePane.setForeground(Color.BLACK);
        titlePane.setEditable(false);


        StyledDocument doc = titlePane.getStyledDocument();
        SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        doc.setParagraphAttributes(0, doc.getLength(), center, false);

        layeredPane.add(titlePane, Integer.valueOf(1));
        this.titlePane.setText(Main.currentArea.name);

        initializeButtons(layeredPane);


        this.setVisible(true);
    }

    private void initializeButtons(JLayeredPane layeredPane) {
        int yshift = 0;
        for (GameAction action : Actions.actions) {
            JButton button = new JButton(action.label);
            button.setBounds(10, 10 + yshift, 100, 30);
            button.addActionListener(action);
            yshift += 40;
            layeredPane.add(button, Integer.valueOf(2));
        }
    }


    public void Tell(String text) {
        if (Main.lastTells.size() >= 100) {
            Main.lastTells.removeFirst();
        }
        Main.lastTells.add(text);
        Update();
    }


    public void Update () {
        var builder = new StringBuilder();
        for (String str : Main.lastTells) {
            builder.append(str).append("\n");
        }

        this.textPane.setText(builder.toString());
        this.titlePane.setText(Main.currentArea.name);


        this.textPane.repaint();
        this.bg.repaint();
    }
}
