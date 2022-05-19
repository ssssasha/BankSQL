import java.nio.file.Files;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;
public class FileReader implements DataAccessService {
    private DataAccessService dataAccess;
    String allWords;
    public  String Reader(String inputFilename){
        try {
            allWords = new String(Files.readAllBytes(Paths.get(inputFilename)));
        } catch (IOException e) {
            System.out.println("No such File!");
            e.printStackTrace();
        }
        return allWords;
    }
}
