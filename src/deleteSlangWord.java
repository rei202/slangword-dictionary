import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class deleteSlangWord implements ActionListener  {
    private JPanel panel1;
    private JButton previousButton;
    private JTable table1;
    private JTextField findBySlangWordTextField;
    private JButton findButton;
    private SlangWordList slangWordList;
    private JFrame rootFrame;
    private JPanel rootPanel;
    private DefaultTableModel model;

    public deleteSlangWord(SlangWordList slangWordList, JFrame rootFrame, JPanel rootPanel) {
        this.slangWordList = slangWordList;
        this.rootFrame = rootFrame;
        this.rootPanel = rootPanel;
    }

    public JPanel fn(){
        model = new DefaultTableModel();
        table1.setModel(model);
        model.addColumn("#");
        model.addColumn("Slang word");
        model.addColumn("Definitions");
        if(slangWordList.getList() != null) {
            showList();
        }
        previousButton.setActionCommand("previous");
        previousButton.addActionListener(this);
        findButton.setActionCommand("find");
        findButton.addActionListener(this);

        table1.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent event) {
                // do some actions here, for example
                // print first column value from selected row
                if (!event.getValueIsAdjusting() && table1.getSelectedRow() != -1){
                    int res = JOptionPane.showOptionDialog(new JFrame(), "Do you want to delete this Slang Word?", "Delete",
                            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                            new Object[] { "Yes", "No" }, JOptionPane.YES_OPTION);
                    if (res == JOptionPane.YES_OPTION) {
                        int pos = table1.getSelectedRow();
                        slangWordList.getList().remove(table1.getValueAt(pos, 1).toString());
                        System.out.println(pos);
                        model.removeRow(pos);
                        for(int i = model.getRowCount() - 1; i >= 0 ; i--){
                            model.removeRow(i);
                        }
                        showList();
                    }
                }

            }
        });
        return panel1;
    }
    private void showList(){
        String [] arr1,arr2;
        arr1 = slangWordList.getList().keySet().toArray(new String[0]);

        for (int i = 0; i < slangWordList.getList().size(); i++){
            ArrayList<String> listDefinition = slangWordList.getList().get(arr1[i]);
            String str = "";
            for (int j = 0; j < listDefinition.size(); j++ ) {
                if(j != listDefinition.size() - 1)
                    str = str + listDefinition.get(j) + " | ";
                else
                    str = str + listDefinition.get(j);
            }
            model.addRow(new Object[]{i, arr1[i], str});
        }

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if(command.equals("previous")) {
            rootFrame.setContentPane(rootPanel);
            rootFrame.invalidate();
            rootFrame.validate();
        }
        else if(command.equals("find")){
            String strSearch = findBySlangWordTextField.getText();
            System.out.println(strSearch);

            for(int i = model.getRowCount() - 1; i >= 0 ; i--){
                model.removeRow(i);
            }
            if(slangWordList.getList().get(strSearch) != null)
                model.addRow(new Object[]{"",strSearch,slangWordList.getList().get(strSearch)});
            if(slangWordList.getList().get(strSearch) == null) {
                showList();
                JOptionPane.showMessageDialog(panel1, "This slang word not exists");
            }
        }
    }
}
