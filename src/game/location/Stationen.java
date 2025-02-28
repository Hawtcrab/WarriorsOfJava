package game.location;

import game.Main;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.IOException;
import java.util.ArrayList;

public class Stationen {
    public static ArrayList<Station> allStations = new ArrayList<>();


    public static void InitializeStations() {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(Main.class.getResource("/game/stations.xml").getFile());
            document.getDocumentElement().normalize();
            Element root = document.getDocumentElement();
            var child = root.getChildNodes();
            for (int i = 0; i < child.getLength(); i++) {
                Node station = child.item(i);

                if (station.getNodeType() == Node.ELEMENT_NODE) {
                    Element stationElement = (Element) station;
                    String name = stationElement.getNodeName();
                    name = name.replaceAll("(?<=[a-z])([A-Z])", " $1");


                    allStations.add(new Station(name));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
