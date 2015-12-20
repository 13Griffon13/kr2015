import java.io.File;

public class CurrPlay{
    private Player player;
    private String song;
    private int pos;
    public CurrPlay(){
        player=new Player(new File("D:/04.wav"));
        player.stop();
    }
    public void setSong(String song){
        this.song=song;
        player.setSound(song);
    }
    public void pause(){
        player.stop();
    }
    public void play(){
        player.play();
    }
    public void play(int pos){

    }
}