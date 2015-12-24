import javax.swing.*;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

/**
 * Created by Griffon on 20.12.2015.
 */
public class SetDirectory extends JFrame {
    private JPanel mainPanel;
    private JTree tree1;
    private JButton addButton;
    private JTextField textField1;

    public SetDirectory(Control control){
        setContentPane(mainPanel);
        setVisible(true);
        pack();
        tree1.setModel(new MyTreeModel("D:/"));
        tree1.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                File fl = (File)tree1.getSelectionPath().getPathComponent(tree1.getSelectionCount());
                textField1.setText(fl.getAbsolutePath());
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                control.addSong(textField1.getText());
            }
        });

    }

}
