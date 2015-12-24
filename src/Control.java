import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

/**
 * Created by Griffon on 18.12.2015.
 */
public class Control {
    private Model model;

    public void setaFloat(float aFloat){
        model.setVolume(aFloat);
    }

    public LinkedList<String> getList(){
        return model.getList();
    }

    Control(Model model){
        this.model=model;
    }

    public ActionListener play = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            model.play();
        }
    };

    public ActionListener pause = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            model.pause();
        }
    };

    public ActionListener prev =new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            model.prevSong();
        }
    };

    public ActionListener next = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            model.nextSong();
        }
    };

    public ActionListener showList = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            PlaylistForm plf = new PlaylistForm(model.getList(),getThis());
        }
    };

    public void setSong(int num){
        model.setSong(num);
    }

    private Control getThis(){
        return this;
    }

    public int getCurProg(){
        return model.getCurProg();
    }

    public int getMaxProgress(){
        return model.getMaxProg();
    }

    public void saveList(String name){
        model.savePL(name);
    }

    public void loadList(String name){
        model.loadPL(name);
    }

    public void dellSong(int num){
        model.dellSong(num);
    }

    public void setProgress(int pos){
        model.pause();
        model.setPos(pos);
        model.play();
    }

    public ActionListener addSongToPL=new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            SetDirectory sd=new SetDirectory(getThis());
        }
    };

    public void addSong(String s){
        model.addSong(s);
    }
}
