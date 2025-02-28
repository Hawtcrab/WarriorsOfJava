package game;

import game.gameactions.GameAction;
import game.location.Station;
import game.location.Stationen;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

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
        var rand = new Random();
        List<Station> available = Stationen.allStations.stream().filter(x -> x != Main.currentArea).toList();
        Main.currentArea = available.get(rand.nextInt(available.size()));
        gui.Tell("Ich nehme die Bahn zur Station..." + Main.currentArea.name + ".");
    }

}
