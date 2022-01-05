import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Stack;

public class findBySlangWord implements ActionListener {
    private JPanel panel1;
    private JTextField findBySlangWordTextField;
    private JButton previousButton;
    private JTable table1;
    private JButton findButton;
    private SlangWordList slangWordList;
    private JFrame rootFrame;
    private JPanel rootPanel;
    private DefaultTableModel model;
    private ArrayList<String> history;

    public findBySlangWord(SlangWordList slangWordList, ArrayList<String> history, JFrame rootFrame, JPanel rootPanel) {
        this.slangWordList = slangWordList;
        this.rootFrame = rootFrame;
        this.rootPanel = rootPanel;
        this.history = history;
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
            if(strSearch != "")
                history.add(strSearch);
            for(int i = model.getRowCount() - 1; i >= 0 ; i--){
                model.removeRow(i);
            }
            if(slangWordList.getList().get(strSearch) != null) {
                model.addRow(new Object[]{strSearch, slangWordList.getList().get(strSearch)});

            }
        }
    }
}
