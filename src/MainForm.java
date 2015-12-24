import javax.swing.*;
import javax.swing.event.AncestorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.LinkedList;

/**
 * Created by Griffon on 18.12.2015.
 */
public class MainForm extends JFrame{
    private JPanel mainPanel;
    private JButton play;
    private JButton pause;
    private JButton next;
    private JButton prev;
    private JSlider slider1;
    private JButton playlistButton;
    private JSlider slider2;
    private boolean chenged=false;


    private Control control;
    public MainForm(){
        setContentPane(mainPanel);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
        slider1.setMinimum(0);
        slider1.setMaximum(130);
        slider1.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                double tmp = slider1.getValue()*0.01;
                System.out.println("Volume: "+(float)tmp);
                control.setaFloat((float)tmp);
            }
        });
        control= new Control(new Model());
        play.addActionListener(control.play);
        pause.addActionListener(control.pause);
        prev.addActionListener(control.prev);
        next.addActionListener(control.next);
        playlistButton.addActionListener(control.showList);
        slider2.addMouseListener(new MouseListener() {
                                     @Override
                                     public void mouseClicked(MouseEvent e) {
                                         chenged=true;
                                     }

                                     @Override
                                     public void mousePressed(MouseEvent e) {
                                         chenged=true;
                                     }

                                     @Override
                                     public void mouseReleased(MouseEvent e) {
                                         control.setProgress(slider2.getValue());
                                         chenged=false;
                                     }

                                     @Override
                                     public void mouseEntered(MouseEvent e) {

                                     }

                                     @Override
                                     public void mouseExited(MouseEvent e) {

                                     }
                                 });

        try {
            mooveProgres();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private void mooveProgres() throws InterruptedException {
        slider2.setMinimum(0);
        slider2.setMaximum(control.getMaxProgress());
        int curprog=0;
        long time;
        while (curprog<=slider2.getMaximum()){
            if(!chenged) {
                time = System.currentTimeMillis();
                while (System.currentTimeMillis() - time < 1) {

                }
                curprog = control.getCurProg();
                slider2.setValue(curprog);

            }
        }
    }

}
