package game;

import game.characters.Player;
import game.gameactions.ActionConditions;
import game.gameactions.GameAction;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class Main {

    public static GUI gui;

    public static final Player PLAYER = new Player();
    public static Area currentArea = new Area();
    public static ArrayList<GameAction> actions = new ArrayList<>();
    public static ArrayDeque<String> lastInputs = new ArrayDeque<>();


    public static void main(String[] args) {
        LoadActions();
        gui = new GUI();
    }

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
                () -> {return true;}));
    }

    public static void moveToNewArea() {
        Main.currentArea = new Area();
        gui.Tell("You move to the " + Main.currentArea.title + ".");
    }
}