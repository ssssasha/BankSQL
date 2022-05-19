import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
public class App {
    static String allWords;

    public static void main(String[] args) throws Exception {
        WordsFilter wordsFilter = new WordsFilter();
        FileReader fileReader = new FileReader();
        wordsFilter.setDataAccess(fileReader);
        wordsFilter.Filter("text.txt");
        //wordsFilter.Filter(fileReader);
    }


}
