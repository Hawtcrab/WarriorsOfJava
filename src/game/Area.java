package game;

import game.characters.Person;

import java.util.LinkedList;
import java.util.Random;

public class Area {
    public String title;
    public LinkedList<Person> people;

    public Area() {
        this.title = RandomName();
        this.people = new LinkedList<>();
        this.people.add(Main.PLAYER);
    }

    private static String RandomName() {
        var random = new Random();
        var noun = new String[] {"Plains", "Fields", "Forest", "Cliffs", "Mountains","River"};
        var badthing = new String[] {"Woe", "Evil", "Danger", "Terror", "Fear", "Death"};
        var name = noun[random.nextInt(noun.length)] + " of "
                + badthing[random.nextInt(badthing.length)];
        return name;
    }


}
