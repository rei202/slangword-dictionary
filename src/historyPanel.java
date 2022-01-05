import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Stack;

public class historyPanel implements ActionListener {
    private JPanel panel1;
    private JButton previousButton;
    private JList list1;
    private JButton reset;
    private ArrayList<String> history;
    private JFrame rootFrame;
    private JPanel rootPanel;
    private DefaultListModel model;

    public historyPanel(ArrayList<String> history, JFrame rootFrame, JPanel rootPanel) {
        this.history = history;
        this.rootFrame = rootFrame;
        this.rootPanel = rootPanel;
    }

    public JPanel fn(){
        model = new DefaultListModel<>();
        list1.setModel(model);
        for (int i = history.size() - 1; i >= 0; i--) {
            model.add(history.size() - 1 - i ,history.get(i));
        }

        previousButton.setActionCommand("previous");
        previousButton.addActionListener(this);
        reset.setActionCommand("reset");
        reset.addActionListener(this);
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
        else if(command.equals("reset")){
            for(int i = model.getSize() - 1; i >= 0 ; i--){
                model.remove(i);
                history.remove(i);
            }
        }
    }
}
