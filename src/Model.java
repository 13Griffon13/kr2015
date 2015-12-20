import java.io.File;
import java.util.LinkedList;

/**
 * Created by Griffon on 18.12.2015.
 */
public class Model {
    private PlayList playList;
    private CurrPlay currPlay;
    private Player player;
    private int pos=0;
    public Model(){
        playList=new PlayList("D:/");
        player=new Player(new File(playList.getByNumber(0)));
    }
    public void play(){
        player.play(pos);
    }
    public void pause(){
       pos= player.stop();
    }
    public void nextSong(){
        player.stop();
        pos=0;
        player=player.setSound(playList.getNext());
    }
    public LinkedList<String> getList(){
        return playList.getList();
    }
    public void prevSong(){
        player.stop();
        pos =0;
        player=player.setSound(playList.getPrev());
    }
    public void setVolume(float vol){
        player.setVolume(vol);
    }
}
