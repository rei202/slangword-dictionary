import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

public class MainFrame extends JFrame implements ActionListener {
    private JPanel mainPanel;
    private JButton displaySlangWordsListButton;
    private JButton findBySlangWordButton1;
    private JButton randomASlangWordButton1;
    private JButton editSlangWordButton1;
    private JButton addNewSlangWordButton1;
    private JButton resetSlangWordsListButton1;
    private JButton deleteSlangWordButton1;
    private JLabel tittle;
    private JButton findByDefinitionButton1;
    private JButton funnyQuestionDefinitionButton;
    private JButton searchingHistoryButton1;
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
        setBounds(450,100,600,600);
        displaySlangWordsListButton.setActionCommand("Display");
        displaySlangWordsListButton.addActionListener(this);

        tittle.setFont(new Font(Font.SANS_SERIF, Font.BOLD,30));

        findBySlangWordButton1.setActionCommand("findBySlangWord");
        findBySlangWordButton1.addActionListener(this);

        addNewSlangWordButton1.setActionCommand("add new slang word");
        addNewSlangWordButton1.addActionListener(this);

        editSlangWordButton1.setActionCommand("edit slang word");
        editSlangWordButton1.addActionListener(this);

        deleteSlangWordButton1.setActionCommand("delete slang word");
        deleteSlangWordButton1.addActionListener(this);

        resetSlangWordsListButton1.setActionCommand("reset");
        resetSlangWordsListButton1.addActionListener(this);

        randomASlangWordButton1.setActionCommand("random");
        randomASlangWordButton1.addActionListener(this);

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
            setSize(700,400);
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
        else if (str.equals("edit slang word")) {
            updateSlangWordPanel updateSlangWordPanel = new updateSlangWordPanel(this.slangwordList, this, mainPanel);
            JPanel panel = updateSlangWordPanel.fn();
            setContentPane(panel);
            setSize(400,200);
            invalidate();
            validate();
        }
        else if (str.equals("delete slang word")) {
            //......................
            deleteSlangWord deleteSlangWord = new deleteSlangWord(this.slangwordList, this, mainPanel);
            JPanel panel = deleteSlangWord.fn();
            setContentPane(panel);
            setSize(700,400);
            invalidate();
            validate();
        }
        else if (str.equals("reset")) {
            //......................
            int res = JOptionPane.showOptionDialog(new JFrame(), "This slang word already exists. Do you want to overwrite?", "",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                    new Object[]{"Yes", "No"}, JOptionPane.YES_OPTION);
            if (res == JOptionPane.YES_OPTION) {
                try {
                    slangwordList.importTxtFile("slang.txt");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
        else if (str.equals("random")) {
            //......................
            randomSlangWordPanel randomSlangWordPanel = new randomSlangWordPanel(this.slangwordList, this, mainPanel);
            JPanel panel = randomSlangWordPanel.fn();
            setContentPane(panel);
            setSize(700,400);
            invalidate();
            validate();
        }
    }
}
