import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;


public class displayPanel extends JPanel implements ActionListener {
    private JPanel panel1;
    private JButton previousButton;
    private JTable table1;
    private SlangWordList slangWordList;
    private JFrame rootFrame;
    private JPanel rootPanel;
    private DefaultTableModel model;

    public displayPanel(SlangWordList slangWordList, JFrame rootFrame, JPanel rootPanel) {
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
        previousButton.setActionCommand("previous");
        previousButton.addActionListener(this);
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
    }
}
