package game;

import game.characters.Person;

import java.util.LinkedList;
import java.util.Random;

public class Area {
    public String title;
    public LinkedList<Person> people;

    // Hier sind zwei Konstrukturen angegeben. Warum?
    // Wie nennt sich dieses Phänomen in Java?

    public Area() {
        this.title = RandomName();
        this.people = new LinkedList<>();
        this.people.add(Main.PLAYER);
    }

    public Area(String name) {
        this.title = name;
        this.people = new LinkedList<>();
        this.people.add(Main.PLAYER);
    }

    // Erstellt einen zufälligen Namen für ein Areal. Wie funktioniert Random()?
    // Warum ist die Methode als "private" markiert?
    private static String RandomName() {
        var random = new Random();
        var noun = new String[] {"Plains", "Fields", "Forest", "Cliffs", "Mountains","River"};
        var badthing = new String[] {"Woe", "Evil", "Danger", "Terror", "Fear", "Death"};
        return noun[random.nextInt(noun.length)] + " of "
                + badthing[random.nextInt(badthing.length)];

    }


}
