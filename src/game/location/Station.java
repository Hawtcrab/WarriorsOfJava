package game.location;

public class Station {
    public final String name;
    public final StationFeature[] features;

    public Station(String name) {
        this.name = name;
        this.features = new StationFeature[0];
    }

    public Station(String name, StationFeature[] features) {
        this.name = name;
        this.features = features == null ? new StationFeature[0] : features;
    }
}
