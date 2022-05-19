import java.nio.file.Files;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;
public class App
{
    static String allWords;
    static String currentWord;
    static String maxWord;


    public static String Filter(String allwords){
        String filterwords = allwords.replaceAll("[^\\p{IsAlphabetic}\\s]", "");
        return filterwords;
    }
    public static String CutWord(String word){
        if(word.length()>30)
            word=word.substring(0,30);
        return word;
    }
    public static String[] MaxLength(String[] word){
        String[] words = word;
        for(int i=0; i< words.length; i++){
            word[i]=CutWord(word[i]);
        }
        return words;
    }
    public static ArrayList<String> Result(ArrayList<String> result, String[] words){
        maxWord="a";
        for(int i=0; i<words.length; i++){
            for (int j=0; j<words.length; j++){
                if(words[j].length()>maxWord.length()){
                    maxWord = words[j];
                }
            }
            if(words[i].length() == maxWord.length()){
                result.add(words[i]);
            }
        }
        Set<String> set = new HashSet<>(result);
        result.clear();
        result.addAll(set);
        return result;
    }
    public static void main(String[] args) throws Exception {
        try {
            allWords = new String(Files.readAllBytes(Paths.get("text.txt")));
        } catch (IOException e) {
            System.out.println("No such File!");
            e.printStackTrace();
        }
        String filterWords = Filter(allWords);
        String[] words = filterWords.split(" ");
        words=MaxLength(words);

        ArrayList<String> result = new ArrayList<String>();
        result=Result(result, words);

        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }
}
