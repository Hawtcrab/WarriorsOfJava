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

    public Area(String name) {
        this.title = name;
        this.people = new LinkedList<>();
        this.people.add(Main.PLAYER);
    }


    private static String RandomName() {
        var random = new Random();
        var noun = new String[] {"Essen Hauptbahnhof", "Viehofer Platz", "Berliner Platz", "Universität Essen", "Rheinischer Platz"};
        return noun[random.nextInt(noun.length)];

    }


}
