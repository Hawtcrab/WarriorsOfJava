package game;

import game.characters.Player;
import game.gameactions.ActionConditions;
import game.gameactions.GameAction;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class Main {

    // Dieses Feld wird in der main-Methode befüllt, und hält alle graphischen Informationen.
    public static GUI gui;

    // Die Main-Klasse enthält viele Informationen über den derzeitigen Status des Spiels.
    // Es wäre sinnvoller, diese in eine andere Klasse auszulagern, um Spielinformationen
    // von technischen Informationen zu trennen,

    // Die folgenden Felder speichern eine Instanz des Spielers, und das derzeitige Gebiet.
    // Aber: Der Spieler ist als 'final' markiert, da es immer nur einen Spieler gibt,
    // und das Feld nicht mehr verändert wird. Das derzeitige Gebiet kann sich sehr wohl
    // ändern.
    public static final Player PLAYER = new Player();
    public static Area currentArea = new Area();


    // Eine Liste aller Aktionen, die der Spieler durchführen kann.
    // Durch iterativen Code in der GUI Klasse wird jede Aktion automatisch auch als Button
    // angezeigt.
    public static ArrayList<GameAction> actions = new ArrayList<>();

    // Eine Liste der letzten Textstücke die über gui.Tell() angezeigt wurden.
    public static ArrayDeque<String> lastTells = new ArrayDeque<>();


    public static void main(String[] args) {
        LoadActions();
        gui = new GUI();
    }

    // Fügt der Liste der verfügbaren Spieleraktionen neue Aktionen hinzu.
    // Wird vor dem GUI aufgerufen, damit das GUI diese Aktionen auch direkt anzeigen kann.

    public static void LoadActions() {
        actions.add(new GameAction("Wave",
                () -> gui.Tell("I wave."), ActionConditions::canWave
        ));
        actions.add(new GameAction("Backflip",
                        () -> gui.Tell("I do a backflip."),
                        () -> true
        ));
        actions.add(new GameAction("Move",
                Main::moveToNewArea,
                () -> true));
    }

    // "Bewegt" den Spieler in ein neues, zufälliges Areal.
    public static void moveToNewArea() {
        Main.currentArea = new Area();
        gui.Tell("You move to the " + Main.currentArea.title + ".");
    }
}