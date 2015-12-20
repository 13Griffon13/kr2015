import javax.swing.*;
import javax.swing.event.AncestorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
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
    private JProgressBar progressBar1;
    private JButton next;
    private JButton prev;
    private JSlider slider1;


    private Control control;
    public MainForm(){
        setContentPane(mainPanel);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
        slider1.setMinimum(0);
        slider1.setMaximum(10);
        slider1.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                double tmp = slider1.getValue()*0.1;
                System.out.println("Volume: "+(float)tmp);
                control.setaFloat((float)tmp);
            }
        });
        control= new Control(new Model());
        play.addActionListener(control.play);
        pause.addActionListener(control.pause);
        prev.addActionListener(control.prev);
        next.addActionListener(control.next);
    }
}
