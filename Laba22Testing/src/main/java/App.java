import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
public class App {
    static Set<String> words = new HashSet<>();

    public static void main(String[] args) {
        Scanner sc;
        try {
            sc = new Scanner(new File("lab.txt"));

            getWords(sc);

            for (String word:
                    words) {
                System.out.println(word);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }



    static Set<String> getWords(Scanner sc){
        words.clear();
        while (sc.hasNextLine()) {
            String line = sc.nextLine();

            String word = "";

            for(int i = 0; i < line.length(); ++i) {
                if(Character.isLetter(line.charAt(i)))
                    word = word+line.charAt(i);
                else if (!word.equals("")){
                    addWord(word);
                    word = "";
                }
            }

            if (!word.equals("")){
                addWord(word);
            }
        }
        return words;
    }

    static String addWord(String s) {
        if(s.length() > 30)
            s = s.substring(0, 29);

        if(isGood(s)) {
            words.add(s);
        }
        return s;
    }

    static boolean isGood(String word) {
        int g = 0, s = 0;

        for(int i = 0; i < word.length(); i++) {
            if (isVowel(word.charAt(i)))
                s++;
            else
                g++;
        }

        return s>g;
    }

    public static boolean isVowel(char c) {
        return "AEIOUYaeiouy".indexOf(c) != -1;
    }
}
