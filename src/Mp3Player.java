import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Created by Griffon on 24.12.2015.
 */
public class Mp3Player extends Thread {
    private AdvancedPlayer player;

    public Mp3Player(String name) throws FileNotFoundException, JavaLayerException {
        player=new AdvancedPlayer(new FileInputStream(name));
    }
    public void pause(){
        player.stop();
    }


    @Override
    public void run() {
        try {
            player.play();
        } catch (JavaLayerException e) {
            e.printStackTrace();
        }
    }
}
