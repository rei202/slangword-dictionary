import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class findByDefinition implements ActionListener {
    private JPanel panel1;
    private JTextField findBySlangWordTextField;
    private JButton findButton;
    private JTable table1;
    private JButton previousButton;
    private SlangWordList slangWordList;
    private JFrame rootFrame;
    private JPanel rootPanel;
    private DefaultTableModel model;

    public findByDefinition(SlangWordList slangWordList, JFrame rootFrame, JPanel rootPanel) {
        this.slangWordList = slangWordList;
        this.rootFrame = rootFrame;
        this.rootPanel = rootPanel;
    }

    public JPanel fn(){
        model = new DefaultTableModel();
        table1.setModel(model);
        model.addColumn("Slang word");
        model.addColumn("Definitions");

        previousButton.setActionCommand("previous");
        previousButton.addActionListener(this);
        findButton.setActionCommand("find");
        findButton.addActionListener(this);
        return panel1;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if(command.equals("previous")) {
            rootFrame.setContentPane(rootPanel);
            rootFrame.setSize(600,600);
            rootFrame.invalidate();
            rootFrame.validate();
        }
        else if(command.equals("find")){
            String strSearch = findBySlangWordTextField.getText();
            for(int i = model.getRowCount() - 1; i >= 0 ; i--){
                model.removeRow(i);
            }
            String[] slangArr = slangWordList.getList().keySet().toArray(new String[0]);
            for (int i = 0; i < slangArr.length; i++){
                ArrayList<String> defArrayofI = slangWordList.getList().get(slangArr[i]);
                if(defArrayofI != null){
                    for (String s: defArrayofI) {
                        if(s.contains(strSearch)){
                            model.addRow(new Object[]{slangArr[i],s});
                        }
                    }
                }

            }

        }
    }
}
