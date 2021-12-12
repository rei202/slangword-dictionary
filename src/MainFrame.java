import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class MainFrame extends JFrame implements ActionListener {
    private JPanel mainPanel;
    private JButton findBySlangWordButton;
    private JButton findByDefinitionButton;
    private JButton searchingHistoryButton;
    private JButton funnyQuestionDefinitionButton;
    private JButton funnyQuestionSlangWordButton;
    private JButton deleteSlangWordButton;
    private JButton editSlangWordButton;
    private JButton addNewSlangWordButton;
    private JButton randomASlangWordButton1;
    private JButton resetSlangWordsListButton1;

    public MainFrame() {
    }

    private void createUI() {
        // TODO: place custom component creation code here
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setContentPane(mainpanel);
        setSize(700,400);
        setVisible(true);
    }
    public static void main(String[] argv){
        MainFrame mainFrame = new MainFrame();
        mainFrame.createUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String str = e.getActionCommand();
        if (str.equals("Import CSV")) {
            //.....................

            setContentPane(panel);
            invalidate();
            validate();
        }
        else if (str.equals("Add 1 Student")) {
            //......................

            setContentPane(panel);
            invalidate();
            validate();
        }
        else if (str.equals("Delete 1 Student")) {
            //......................

            setContentPane(panel);
            invalidate();
            validate();
        }
        else if (str.equals("Update Student")) {
            //......................
            System.out.println("Process for button4");

            setContentPane(panel);
            invalidate();
            validate();
        }
        else if (str.equals("Display Student List")) {
            //......................

            setContentPane(panel);
            invalidate();
            validate();
        }
        else if (str.equals("Export CSV")) {
            //......................

        }
        else if (str.equals("Save to Database")) {
            //......................

            setContentPane(panel);
            invalidate();
            validate();
        }
    }
}
