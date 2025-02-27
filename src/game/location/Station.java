package game.location;

public class Station {
    public final String name;
    public final StationFeature[] features;

    public Station(String name) {
        this.name = name;
        this.features = new StationFeature[0];
    }
}
