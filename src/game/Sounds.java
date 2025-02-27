package game;

import javax.sound.sampled.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Sounds {

    public static void playSound(String name) {
        try {
            var stream = Sounds.class.getResourceAsStream("/game/sounds/" +name + ".wav");
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(stream);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
            clip.addLineListener(event -> {
                if (event.getType() == LineEvent.Type.STOP) {
                    clip.close();
                }
            });
        }
        catch (Exception e) {System.out.println(e);}
    }


    public static String RUMMAGE = "rummage";

}
