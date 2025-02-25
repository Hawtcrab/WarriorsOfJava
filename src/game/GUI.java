package game;

import game.gameactions.GameAction;

import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class GUI extends JFrame {

    // Das Fenster, in welchem die Resultate der letzten Aktionen gezeigt werden.
    private JTextArea textPane;
    // Das Fenster, in welchem der Titel des derzeitigen Gebiets gezeigt wird.
    private JTextPane titlePane;

    /// Erstellt das eigentl. Fenster, und initialisiert dann die Grafikelemente.
    public GUI () {
        super("Warriors of Java");
        // Setzt ein paar Grundeinstellungen über das neuerstellte Fenster.
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600,400);
        this.setResizable(false);
        // Es gibt verschiedene Techniken für die Platzierung von Grafikelementen.
        // Hier deklarieren wir, dass wir kein eingebautes Verfahren nutzen wollen,
        // sondern die Koordinaten und Größe der Elemente manuell angeben.
        setLayout(null);
        initializeElements();
    }

    // Initialisiert alle Elemente innerhalb des Hauptfensters.
    private void initializeElements () {

        initializeButtons();

        // Initialize the text area for output
        var screen = new JTextArea();
        screen.setEditable(false);
        screen.setLineWrap(true);
        screen.setWrapStyleWord(true);
        screen.setBorder(BorderFactory.createEtchedBorder());

        // Create the scroll pane that contains the text area
        JScrollPane scrollPane = new JScrollPane(screen);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        // Set bounds for the scroll pane, not the text area
        scrollPane.setBounds(120, 10, 410, 300);

        // Add only the scroll pane to the container
        add(scrollPane);

        this.textPane = screen;
        this.setVisible(true);

        // Create the title pane
        titlePane = new JTextPane();
        titlePane.setBounds(120, 310, 410, 20);
        titlePane.setBorder(BorderFactory.createEtchedBorder());

        // Center the title text
        StyledDocument doc = titlePane.getStyledDocument();
        SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        doc.setParagraphAttributes(0, doc.getLength(), center, false);
        add(titlePane);

        Update();
    }

    // Iteriert über einen for-Loop durch die Liste aller Spieleraktionen, und erstellt
    // für jede Aktion einen Button.
    private void initializeButtons() {
        var yshift = 0;
        for (GameAction action : Main.actions) {
            var button = new JButton(action.label);
            button.setBounds(10, 10 + yshift, 100, 30);

            // Informier dich gerne mal über Events und Listener. Nicht wirklich behandelt
            // in der Vorlesung, aber für tatsächliche Entwicklung super wichtig.
            button.addActionListener(action);

            // Sorgt dafür, dass der nächste Knopf um 40 Einheiten nach unten geschoben wird.
            // Sonst würden sich die Knöpfe überlagern.
            yshift += 40;

            add(button);
        }
    }

    /// Wichtige Methode. Sorgt dafür, dass auf dem Ausgabefeld neuer Text gezeigt wird.
    /// Wenn der Spieler Feedback bekommen soll, muss Tell() verwendet werden.
    public void Tell(String text) {
        if (Main.lastTells.size() >= 18) {
            Main.lastTells.removeFirst();
        }
        Main.lastTells.add(text);
        Update();
    }

    /// Erneuert die Textanzeige, und sorgt dafür, dass neue Ausgaben auch angezeigt werdne.
    public void Update () {
        var builder = new StringBuilder();
        for (String str : Main.lastTells) {
            builder.append(str);
            builder.append("\n");
        }
        this.textPane.setText(builder.toString());
        this.titlePane.setText(Main.currentArea.title);
    }
}
