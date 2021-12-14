import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeMap;

public class SlangWordList {
    private TreeMap<String, String> list;


    public SlangWordList() {
        this.list = null;
    }

    public TreeMap<String, String> getList() {
        return list;
    }

    public void setList(TreeMap<String, String> list) {
        this.list = list;
    }

    public void importTxtFile(String filename) throws IOException {
        list = new TreeMap<>();
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader(filename));
        }
        catch(FileNotFoundException exc) {
            System.out.println("File Not Found");
            return;
        }

        String str = br.readLine();
        while (true) {
            str = br.readLine();
            if (str == null)
                break;
            String[] temp = str.split("`");
            if(temp.length == 1)
                continue;
            list.put(temp[0], temp[1]);
        }
    }
}
