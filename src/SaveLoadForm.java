import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Griffon on 23.12.2015.
 */
public class SaveLoadForm extends JFrame {
    private JPanel mainPanel;
    private JTextField textField1;
    private JButton saveLoadButton;
    private JLabel saveLoadLable;

    public SaveLoadForm(String saveLoad,Control control){
        setContentPane(mainPanel);
        saveLoadButton.setText(saveLoad);
        saveLoadLable.setText(saveLoad);
        setVisible(true);
        pack();
        if(saveLoad.equals("Save")){
            saveLoadButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    control.saveList(textField1.getText());
                    setVisible(false);
                }
            });
        }else{
            saveLoadButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    control.loadList(textField1.getText());
                    setVisible(false);
                }
            });
        }
    }
}
