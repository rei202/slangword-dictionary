import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

public class addSlangWordPanel implements ActionListener {
    private JPanel panel1;
    private JTextField textField1;
    private JTextField textField2;
    private JButton previousButton;
    private JButton addButton;
    private SlangWordList slangWordList;
    private JFrame rootFrame;
    private JPanel rootPanel;

    public addSlangWordPanel(SlangWordList slangWordList, JFrame rootFrame, JPanel rootPanel) {
        this.slangWordList = slangWordList;
        this.rootFrame = rootFrame;
        this.rootPanel = rootPanel;
    }

    public JPanel fn(){

        previousButton.setActionCommand("previous");
        previousButton.addActionListener(this);
        addButton.setActionCommand("add");
        addButton.addActionListener(this);
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
        else if(command.equals("add")) {
            String slang = textField1.getText();
            String def = textField2.getText();
            if(slangWordList.getList().get(slang) == null) {
                ArrayList listDef = new ArrayList<String>();
                listDef.add(def);
                slangWordList.getList().put(slang, listDef);
                JOptionPane.showMessageDialog(panel1, "Successfully");
            }
            else {
                int res = JOptionPane.showOptionDialog(new JFrame(), "This slang word already exists. Do you want to overwrite?", "",
                        JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                        new Object[]{"Overwrite", "Add definition", "Cancel"}, JOptionPane.YES_OPTION);
                if (res == JOptionPane.YES_OPTION) {
                    slangWordList.getList().remove(slang);
                    ArrayList listDef = new ArrayList<String>();
                    listDef.add(def);
                    slangWordList.getList().put(slang, listDef);
                }
                else if(res == JOptionPane.NO_OPTION){
                    ArrayList listDef = slangWordList.getList().get(slang);
                    listDef.add(def);
                }
            }
        }
    }

}
