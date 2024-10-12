package game.gameactions;

import game.Main;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.function.BooleanSupplier;

/// Diese Klasse repräsentiert eine Aktion, die ein Spieler durchführen kann.
/// Sie implementiert ActionListener. Finde heraus, warum.
public class GameAction implements ActionListener {

    Runnable action;
    BooleanSupplier condition;
    public String label;

    public GameAction (String label, Runnable action, BooleanSupplier condition) {
        super();
        this.label = label;
        this.action = action;
        this.condition = condition;
    }

    // Hier wurde eine Methode überschrieben.
    @Override
    public void actionPerformed(ActionEvent e) {
        if(!Main.PLAYER.isAlive()) {
            Main.gui.Tell("You can't perform an action, you're dead!");
            return;
        }
        else if (!this.condition.getAsBoolean()) {
            Main.gui.Tell("You can't perform this action for some reason.");
            return;
        }
        action.run();
    }

}
