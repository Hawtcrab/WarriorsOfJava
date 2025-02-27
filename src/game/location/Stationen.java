package game.location;

import java.util.ArrayList;

public class Stationen {
    public static ArrayList<Station> allStations = new ArrayList<>();

    private Station registerStation(String name, StationFeature... features) {
        var station = new Station(name, features);
        return station;
    }

    public static final Station ESSENHBF = new Station("Essen Hauptbahnhof");
    public static final Station VIEHOFERPLATZ = new Station("Viehofer Platz");
}
