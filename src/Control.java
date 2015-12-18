import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Griffon on 18.12.2015.
 */
public class Control {
    Model model;
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
}
