import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class MainFrame extends JFrame implements ActionListener {
    private JPanel mainPanel;
    private JButton displaySlangWordsListButton;
    private JButton findBySlangWordButton1;
    private JButton findByDefinitionButton1;
    private JButton funnyQuestionDefinitionButton;
    private JButton randomASlangWordButton1;
    private JButton editSlangWordButton1;
    private JButton addNewSlangWordButton1;
    private JButton searchingHistoryButton1;
    private JButton resetSlangWordsListButton1;
    private JButton deleteSlangWordButton1;
    private JButton funnyQuestionSlangWordButton1;

    private SlangWordList slangwordList;

    public MainFrame() {
        slangwordList = new SlangWordList();
    }

    public SlangWordList getSlangwordList() {
        return slangwordList;
    }


    private void createUI() {
        // TODO: place custom component creation code here
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setContentPane(mainPanel);
        setSize(600,400);
        setBounds(500,150,600,400);
        displaySlangWordsListButton.setActionCommand("Display");
        displaySlangWordsListButton.addActionListener(this);
        findBySlangWordButton1.setActionCommand("findBySlangWord");
        findBySlangWordButton1.addActionListener(this);
        addNewSlangWordButton1.setActionCommand("add new slang word");
        addNewSlangWordButton1.addActionListener(this);
        setVisible(true);

    }
    public static void main(String[] argv) throws IOException {
        MainFrame mainFrame = new MainFrame();
        mainFrame.createUI();
        mainFrame.getSlangwordList().importTxtFile("slang.txt");
        String [] arr = mainFrame.getSlangwordList().getList().keySet().toArray(new String[0]);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String str = e.getActionCommand();
        if (str.equals("Display")) {
            //.....................
            displayPanel displayPanel = new displayPanel(this.slangwordList, this, mainPanel);
            JPanel panel = displayPanel.fn();
            setContentPane(panel);
            //invalidate();
            validate();
            //repaint();
        }
        else if (str.equals("findBySlangWord")) {
            //......................
            findBySlangWord findBySlangWord = new findBySlangWord(this.slangwordList, this, mainPanel);
            JPanel panel = findBySlangWord.fn();
            setContentPane(panel);
            invalidate();
            validate();
        }
//        else if (str.equals("Delete 1 Student")) {
//            //......................
//
//            setContentPane(panel);
//            invalidate();
//            validate();
//        }
//        else if (str.equals("Update Student")) {
//            //......................
//            System.out.println("Process for button4");
//
//            setContentPane(panel);
//            invalidate();
//            validate();
//        }
        else if (str.equals("add new slang word")) {
            //......................
            addSlangWordPanel addSlangWordPanel = new addSlangWordPanel(this.slangwordList, this, mainPanel);
            JPanel panel = addSlangWordPanel.fn();
            setContentPane(panel);
            setSize(400,200);
            invalidate();
            validate();
        }
//        else if (str.equals("Export CSV")) {
//            //......................
//
//        }
//        else if (str.equals("Save to Database")) {
//            //......................
//
//            setContentPane(panel);
//            invalidate();
//            validate();
//        }
    }
}
