import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

public class funnyQuestionDefinition implements ActionListener {
    private JPanel panel1;
    private JLabel title;
    private JLabel question;
    private JButton button1Button;
    private JButton button3Button;
    private JButton button2Button;
    private JButton button4Button;
    private JButton backButton;
    private JButton resetButton;
    private SlangWordList slangWordList;
    private JFrame rootFrame;
    private JPanel rootPanel;
    private String correctAnswer;

    public funnyQuestionDefinition(SlangWordList slangWordList, JFrame rootFrame, JPanel rootPanel) {
        this.slangWordList = slangWordList;
        this.rootFrame = rootFrame;
        this.rootPanel = rootPanel;
    }

    public JPanel fn(){
        title.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
//        centerPan.setBorder(BorderFactory.createRaisedBevelBorder());
        backButton.setActionCommand("previous");
        backButton.addActionListener(this);
        randomeAnwser();

//        int randomAnswerButton1 = randomGenerator.nextInt(4);
//        int randomAnswerButton2 = randomGenerator.nextInt(4);
//        int randomAnswerButton3 = randomGenerator.nextInt(4);
//        int randomAnswerButton4 = randomGenerator.nextInt(4);
//
        button1Button.setActionCommand("button1");
        button2Button.setActionCommand("button2");
        button3Button.setActionCommand("button3");
        button4Button.setActionCommand("button4");
        button1Button.addActionListener(this);
        button2Button.addActionListener(this);
        button3Button.addActionListener(this);
        button4Button.addActionListener(this);
        resetButton.setActionCommand("reset");
        resetButton.addActionListener(this);
//
//        defLabel.setText("It means: " + defString);
//        defLabel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));
        return panel1;
    }
    private void randomeAnwser(){
        String [] randomKey = slangWordList.getList().keySet().toArray(new String[0]);
        Random randomGenerator = new Random();
        int randomIndexQuestion = randomGenerator.nextInt(randomKey.length);
        correctAnswer = randomKey[randomIndexQuestion];
        question.setText("What does it mean: " + '"' + slangWordList.getList().get(correctAnswer).get(0) + '"');
        String[] arrAnswer = new String[4];
        arrAnswer[0] = correctAnswer;;

        int randomIndexAnwser;
        int i = 1;
        while(true){
            randomIndexAnwser = randomGenerator.nextInt(randomKey.length);
            String incorrectAnswer = randomKey[randomIndexAnwser];;
            int check = 0;
            for (String e: arrAnswer) {
                if(e == null)
                    break;
                if(e.equals(incorrectAnswer))
                    check = 1;
            }

            if(check == 0){
                arrAnswer[i] = incorrectAnswer;
                i++;
            }
            if(i == 4)
                break;
        }

        Set<Integer> set = new LinkedHashSet<Integer>();
        while (set.size() < 4) {
            set.add(randomGenerator.nextInt(4));
        }
        button1Button.setText(arrAnswer[(int) set.toArray()[0]]);
        button2Button.setText(arrAnswer[(int) set.toArray()[1]]);
        button3Button.setText(arrAnswer[(int) set.toArray()[2]]);
        button4Button.setText(arrAnswer[(int) set.toArray()[3]]);

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
        else if(command.equals("button1")) {
            if(button1Button.getText().equals(correctAnswer)){
                button1Button.setBackground(Color.GREEN);
                JOptionPane.showMessageDialog(panel1, "Correct ^_^ ");

            }
            else{
                button1Button.setBackground(Color.RED);
                JOptionPane.showMessageDialog(panel1, "Wrong. You can try again ^_^ ");
                if(button2Button.getText().equals(correctAnswer)){
                    button2Button.setBackground(Color.GREEN);
                }
                if(button3Button.getText().equals(correctAnswer)){
                    button3Button.setBackground(Color.GREEN);
                }
                if(button4Button.getText().equals(correctAnswer)){
                    button4Button.setBackground(Color.GREEN);
                }
            }


        }
        else if(command.equals("button2")) {
            if(button2Button.getText().equals(correctAnswer)){
                button2Button.setBackground(Color.GREEN);
                JOptionPane.showMessageDialog(panel1, "Correct ^_^ ");

            }
            else{
                button2Button.setBackground(Color.RED);
                JOptionPane.showMessageDialog(panel1, "Wrong. You can try again ^_^ ");
                if(button1Button.getText().equals(correctAnswer)){
                    button1Button.setBackground(Color.GREEN);
                }
                if(button3Button.getText().equals(correctAnswer)){
                    button3Button.setBackground(Color.GREEN);
                }
                if(button4Button.getText().equals(correctAnswer)){
                    button4Button.setBackground(Color.GREEN);
                }

            }


        }
        else if(command.equals("button3")) {
            if(button3Button.getText().equals(correctAnswer)){
                button3Button.setBackground(Color.GREEN);
                JOptionPane.showMessageDialog(panel1, "Correct ^_^ ");

            }
            else{
                button3Button.setBackground(Color.RED);
                JOptionPane.showMessageDialog(panel1, "Wrong. You can try again ^_^ ");
                if(button1Button.getText().equals(correctAnswer)){
                    button1Button.setBackground(Color.GREEN);
                }
                if(button2Button.getText().equals(correctAnswer)){
                    button2Button.setBackground(Color.GREEN);
                }
                if(button4Button.getText().equals(correctAnswer)){
                    button4Button.setBackground(Color.GREEN);
                }
            }


        }
        else if(command.equals("button4")) {
            if(button4Button.getText().equals(correctAnswer)){
                button4Button.setBackground(Color.GREEN);
                JOptionPane.showMessageDialog(panel1, "Correct ^_^ ");

            }
            else{
                button4Button.setBackground(Color.RED);
                JOptionPane.showMessageDialog(panel1, "Wrong. You can try again ^_^ ");
                if(button1Button.getText().equals(correctAnswer)){
                    button1Button.setBackground(Color.GREEN);
                }
                if(button2Button.getText().equals(correctAnswer)){
                    button2Button.setBackground(Color.GREEN);
                }
                if(button3Button.getText().equals(correctAnswer)){
                    button3Button.setBackground(Color.GREEN);
                }
            }

        }
        else if(command.equals("reset")){
            button1Button.setBackground(Color.white);
            button2Button.setBackground(Color.white);
            button3Button.setBackground(Color.white);
            button4Button.setBackground(Color.white);
            randomeAnwser();
        }
    }
}
