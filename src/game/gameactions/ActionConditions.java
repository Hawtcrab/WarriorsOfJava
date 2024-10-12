package game.gameactions;

import game.Main;

// Hier handelt es sich um eine sog. statische Klasse, da sie nur statische Methoden
// enthält. Finde heraus, wo canWave verwendet wird, und warum.
public class ActionConditions {
    public static boolean canWave() {
        if (Main.currentArea.people.isEmpty()) return false;
        return Main.currentArea.people.stream().anyMatch(p -> !p.isPlayer());
    }
}
