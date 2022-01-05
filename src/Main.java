import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        MainFrame mainFrame = new MainFrame();
        mainFrame.createUI();
        mainFrame.getSlangwordList().importTxtFile("slang.txt");
        mainFrame.loadHistory("history.txt");    }
}
