import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.*;
import java.util.LinkedList;

/**
 * Created by Griffon on 20.12.2015.
 */
public class PlaylistForm extends JFrame {
    private JPanel mainPanel;
    private JList list1;
    private JButton addButton;
    private JButton dellButton;
    private JButton loadButton;
    private JButton saveButton;
    private boolean dclik=false;
    private SaveLoadForm slForm;

    public PlaylistForm(LinkedList<String> lls, Control control) {
        setContentPane(mainPanel);
        pack();
        setVisible(true);
        DefaultListModel<String> lm = new DefaultListModel<>();
        list1.setModel(lm);
        for (int i = 0; i < lls.size(); i++) {
            lm.addElement(lls.get(i));
        }
        list1.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if(dclik){
                    control.setSong(list1.getSelectedIndex());
                    dclik=false;
                } else {
                    dclik=true;
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        list1.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                dclik=false;
            }
        });
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               slForm= new SaveLoadForm("Save", control);
            }
        });
        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               slForm= new SaveLoadForm("Load",control);
            }
        });
        dellButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i=list1.getSelectedIndex();
                control.dellSong(i);
                lm.remove(i);
                control.setSong(i++);
            }
        });
        addButton.addActionListener(control.addSongToPL);

    }
}
