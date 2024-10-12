package game;

import game.gameactions.GameAction;

import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class GUI extends JFrame {

    // Zwei Textfelder, eines zeigt die Textausgabe an, das andere den Titel des Areals.
    private JTextPane textPane;
    private JTextPane titlePane;

    /// Erstellt das eigentl. Fenster, und initialisiert dann die Grafikelemente.
    public GUI () {
        super("Warriors of Java");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600,400);
        this.setResizable(false);
        setLayout(null);
        initializeElements();
    }

    private void initializeElements () {

        initializeButtons();
        var screen = new JTextPane();
        screen.setEditable(false);
        screen.setBounds(120,10, 410, 300);
        screen.setBorder(BorderFactory.createEtchedBorder());
        add(screen);
        this.textPane = screen;
        this.setVisible(true);
        // Title below the textbox
        titlePane =  new JTextPane();
        titlePane.setBounds(120, 310, 410, 20);
        titlePane.setBorder(BorderFactory.createEtchedBorder());
        //Horizonal Centering
        StyledDocument doc = titlePane.getStyledDocument();
        SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        doc.setParagraphAttributes(0, doc.getLength(), center, false);
        add(titlePane);
        Update();
    }

    private void initializeButtons() {
        var yshift = 0;
        for (GameAction action : Main.actions) {
            var button = new JButton(action.label);
            button.setBounds(10, 10 + yshift, 100, 30);
            button.addActionListener(action);
            yshift += 40;
            add(button);
        }
    }

    public void Tell(String text) {
        if (Main.lastInputs.size() >= 18) {
            Main.lastInputs.removeFirst();
        }
        Main.lastInputs.add(text);
        Update();
    }

    public void Update () {
        var builder = new StringBuilder();
        for (String str : Main.lastInputs) {
            builder.append(str + "\n");
        }
        this.textPane.setText(builder.toString());
        this.titlePane.setText(Main.currentArea.title);
    }
}
