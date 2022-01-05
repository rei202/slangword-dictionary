import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.util.ArrayList;
import java.util.Stack;
import java.util.TreeMap;

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
    private ArrayList<String> history;


    public MainFrame() {
        slangwordList = new SlangWordList();
    }

    public SlangWordList getSlangwordList() {
        return slangwordList;
    }


    void createUI() {
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

        findByDefinitionButton1.setActionCommand("findByDefinition");
        findByDefinitionButton1.addActionListener(this);

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

        funnyQuestionSlangWordButton1.setActionCommand("funnyQuestionSlang");
        funnyQuestionSlangWordButton1.addActionListener(this);

        funnyQuestionDefinitionButton.setActionCommand("funnyQuestionDef");
        funnyQuestionDefinitionButton.addActionListener(this);

        searchingHistoryButton1.setActionCommand("history");
        searchingHistoryButton1.addActionListener(this);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                // Do what you want when the window is closing.
                try {
                    saveFile(slangwordList.getList(), "slang.txt");
                    saveHistory(history,"history.txt");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });



        setVisible(true);

    }

    private void saveFile(TreeMap<String, ArrayList<String>> arr, String fileName) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        String [] arrKey = arr.keySet().toArray(new String[0]);
        for (int i = 0; i < arrKey.length; i++) {
            String str = "";
            str = str + arrKey[i] + "`";
            ArrayList<String> defOfKey = arr.get(arrKey[i]);
            for (int j = 0; j < defOfKey.size(); j ++) {
                if(j == defOfKey.size() - 1)
                    str = str + defOfKey.get(j);
                else
                    str = str + defOfKey.get(j) + "|";

            }
            if(i == arrKey.length - 1)
                bw.write(str);
            else
                bw.write(str + "\n");
        }
        bw.close();
    }

    private void saveHistory(ArrayList<String> arr, String fileName) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        for (int i = 0; i < history.size(); i++) {
            if(i == history.size() - 1)
                bw.write(history.get(i));
            else
                bw.write(history.get(i) + "\n");
        }
        bw.close();
    }
    public void loadHistory(String fileName) throws IOException {
        history = new ArrayList<>();
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader(fileName));
        }
        catch(FileNotFoundException exc) {
            System.out.println("File Not Found");
            return;
        }
        ArrayList<String> listDefinition;
        String str;
        while (true) {
            str = br.readLine();
            if (str == null)
                break;

            history.add(str);
        }
        br.close();
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
        if (str.equals("history")) {
            //.....................
            historyPanel historyPanel = new historyPanel(history, this, mainPanel);
            JPanel panel = historyPanel.fn();
            setContentPane(panel);
            setSize(600,600);
            //invalidate();
            validate();
            //repaint();
        }
        else if (str.equals("findBySlangWord")) {
            //......................
            findBySlangWord findBySlangWord = new findBySlangWord(this.slangwordList, history,this, mainPanel);
            JPanel panel = findBySlangWord.fn();
            setContentPane(panel);
            invalidate();
            validate();
        }
        else if (str.equals("findByDefinition")) {
            //......................
            findByDefinition findByDefinition = new findByDefinition(this.slangwordList, this, mainPanel);
            JPanel panel = findByDefinition.fn();
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
                    slangwordList.importTxtFile("slangSource.txt");
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
        else if (str.equals("funnyQuestionSlang")) {
            //......................
            funnyQuestionSlangPanel funnyQuestionSlangPanel = new funnyQuestionSlangPanel(this.slangwordList, this, mainPanel);
            JPanel panel = funnyQuestionSlangPanel.fn();
            setContentPane(panel);
            setSize(700,400);
            invalidate();
            validate();
        }
        else if (str.equals("funnyQuestionDef")) {
            //......................
            funnyQuestionDefinition funnyQuestionDefinition = new funnyQuestionDefinition(this.slangwordList, this, mainPanel);
            JPanel panel = funnyQuestionDefinition.fn();
            setContentPane(panel);
            setSize(700,400);
            invalidate();
            validate();
        }
    }
}
