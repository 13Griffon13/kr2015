import javazoom.jl.decoder.JavaLayerException;

/**
 * Created by Griffon on 18.12.2015.
 */
public class Model {
    PlayList playList;
    CurrPlay currPlay;
    public Model(){
        playList=new PlayList("D:/");
        currPlay=new CurrPlay();
        currPlay.setSong(playList.getByNumber(0));
    }
    public void play(){
        if(currPlay.isPaused()){
            currPlay.res();
        }else {
            currPlay.play();
        }
    }
    public void pause(){
        currPlay.pause();
    }
}
