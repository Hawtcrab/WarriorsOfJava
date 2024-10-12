package game.gameactions;

import game.Main;

public class ActionConditions {
    public static boolean canWave() {
        if (Main.currentArea.people.isEmpty()) return false;
        return Main.currentArea.people.stream().anyMatch(p -> !p.isPlayer());
    }
}
