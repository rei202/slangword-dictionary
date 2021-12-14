import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


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
            arr2 =slangWordList.getList().values().toArray(new String[0]);
            for (int i = 0; i < slangWordList.getList().size(); i++)
                model.addRow(new Object[]{i, arr1[i], arr2[i]});
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
            rootFrame.invalidate();
            rootFrame.validate();
        }
    }
}
