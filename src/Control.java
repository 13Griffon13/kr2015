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
}
