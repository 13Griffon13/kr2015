import javax.swing.*;

/**
 * Created by Griffon on 18.12.2015.
 */
public class MainForm extends JFrame{
    private JPanel mainPanel;
    private JButton play;
    private JButton pause;


    private Control control;
    public MainForm(){
        setContentPane(mainPanel);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
        control= new Control(new Model());
        play.addActionListener(control.play);
        pause.addActionListener(control.pause);
    }
}
