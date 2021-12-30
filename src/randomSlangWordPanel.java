import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class randomSlangWordPanel implements ActionListener {
    private JPanel panel1;
    private JButton previousButton;
    private JLabel slangLabel;
    private JLabel defLabel;
    private JLabel tittle;
    private JPanel centerPan;
    private SlangWordList slangWordList;
    private JFrame rootFrame;
    private JPanel rootPanel;

    public randomSlangWordPanel(SlangWordList slangWordList, JFrame rootFrame, JPanel rootPanel) {
        this.slangWordList = slangWordList;
        this.rootFrame = rootFrame;
        this.rootPanel = rootPanel;
    }

    public JPanel fn(){
        tittle.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
        centerPan.setBorder(BorderFactory.createRaisedBevelBorder());
        previousButton.setActionCommand("previous");
        previousButton.addActionListener(this);
        String [] randomKey = slangWordList.getList().keySet().toArray(new String[0]);
        Random randomGenerator = new Random();
        int randomIndex = randomGenerator.nextInt(randomKey.length);
//        int randomIndex = (int)Math.random()*(randomKey.length - 0 + 1) + 0;
        String slang = randomKey[randomIndex];
        ArrayList<String> def = slangWordList.getList().get(slang);
        slangLabel.setText("Randome slangword is: " + '"'+slang + '"');
        slangLabel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));
        String defString = "";
        for (int i = 0; i < def.size(); i++) {
            if(i != def.size() -1)
                defString =  defString + '"' +def.get(i) + '"' +" or ";
            else
                defString += '"' +def.get(i) + '"';
        }

        defLabel.setText("It means: " + defString);
        defLabel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));
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
