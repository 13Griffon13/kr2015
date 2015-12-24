import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

/**
 * Created by Griffon on 18.12.2015.
 */
public class Model{
    private PlayList playList;
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

    public void setSong(int num){
        player.stop();
        pos=0;
        player= player.setSound(playList.getByNumber(num));
    }

    public void setVolume(float vol){
        player.setVolume(vol);
    }

    public int getMaxProg(){
        return player.getMaxProg();
    }

    public int getCurProg(){
        return player.getCurPos();
    }

    public void setPos(int pos){
        this.pos=pos;
    }

    public void swapSong(int i,int k){
        playList.swap(i,k);
    }

    public void savePL(String name){
        try {
            playList.saveList(name);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadPL(String name){
        try {
            playList.loadList(name);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void dellSong(int num){
        playList.delSong(num);
    }

    public void addSong(String s){
        playList.addSong(s);
    }

}
