package game.characters;

public class Person {
    public int HP = 10;
    String name = "Somedude.";

    public boolean isAlive() {
        return HP > 0;
    }

    public boolean isPlayer() {
        return false;
    }
}
