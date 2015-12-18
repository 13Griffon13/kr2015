import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import java.io.*;
import java.util.Observable;

/**
 * Created by Griffon on 18.12.2015.
 */
public class CurrPlay extends Observable implements Runnable {
    private Player player;
    private String song;
    private int pos=0;
    private boolean paused;

    public CurrPlay(){

    }
    public void setSong(String song){
        pos=0;
        paused=false;
        System.out.println("Played:"+song);
        try {
            player = new Player(new FileInputStream(song));
        } catch (JavaLayerException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void pause(){
        synchronized (this) {
            pos=player.getPosition();
            player.close();
            paused=true;
        }
    }
    public void res(){
        synchronized (this) {
            paused = false;
        }
    }
    public void play()  {
        Thread tmp = new Thread(this);
        tmp.start();
        paused =false;
    }
    public boolean isPaused(){
            return paused;
    }
    @Override
    public void run() {
        while (true){
            if(paused){//проблемма с потоком, код должен быть рабочий

            }
            else{
                try {
                    if(pos!=0){
                        player.play(pos);
                    } else{
                        player.play();
                    }
                } catch (JavaLayerException e) {
                    e.printStackTrace();
                }
                }
            }
        }

    }
