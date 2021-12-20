import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class updateSlangWordPanel implements ActionListener {
    private JPanel panel1;
    private JTextField textField2;
    private JTextField textField1;
    private JButton previousButton;
    private JButton updateButton;
    private SlangWordList slangWordList;
    private JFrame rootFrame;
    private JPanel rootPanel;

    public updateSlangWordPanel(SlangWordList slangWordList, JFrame rootFrame, JPanel rootPanel) {
        this.slangWordList = slangWordList;
        this.rootFrame = rootFrame;
        this.rootPanel = rootPanel;
    }

    public JPanel fn(){

        previousButton.setActionCommand("previous");
        previousButton.addActionListener(this);
        updateButton.setActionCommand("update");
        updateButton.addActionListener(this);
        return panel1;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if(command.equals("previous")) {
            rootFrame.setContentPane(rootPanel);
            rootFrame.setSize(600,400);
            rootFrame.invalidate();
            rootFrame.validate();
        }
        else if(command.equals("update")) {
            String slang = textField1.getText();
            String def = textField2.getText();
            if (slangWordList.getList().get(slang) != null) {
                slangWordList.getList().remove(slang);
                slangWordList.getList().put(slang, def);
                JOptionPane.showMessageDialog(panel1, "Successfully");
            } else
                JOptionPane.showMessageDialog(panel1, "This slang word not exists");

        }
    }
}
