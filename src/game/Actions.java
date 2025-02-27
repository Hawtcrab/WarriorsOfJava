package game;

import game.gameactions.GameAction;

import java.util.ArrayList;

import static game.Main.gui;

public class Actions {

    public static ArrayList<GameAction> actions = new ArrayList<>();

    public static void LoadActions() {
        actions.add(new GameAction("Wühlen",
                Actions::Rummage, () -> true
        ));
        actions.add(new GameAction("Warten",
                () -> gui.Tell("Ich warte eine Minute."),
                () -> true
        ));
        actions.add(new GameAction("Move",
                Actions::takeTrain,
                () -> true));
    }

    public static void Rummage() {
        gui.Tell("Ich wühle im Müll herum.");
        Sounds.playSound(Sounds.RUMMAGE);
    }

    public static void takeTrain() {
        Main.currentArea = new Area();
        gui.Tell("Ich nehme die Bahn zur Station..." + Main.currentArea.title + ".");
    }

}
