import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class WordsFilter {
    private DataAccessService dataAccess;
    String allwords;
    String currentWord;
    String maxWord;

    public void setDataAccess(DataAccessService dataAccess) {
        this.dataAccess = dataAccess;
    }

    public String Filter(String inputFilename){
        String w = this.dataAccess.Reader(inputFilename);
        String filterwords = w.replaceAll("[^\\p{IsAlphabetic}\\s]", "");
        String[] words = filterwords.split(" ");
        words=MaxLength(words);
        ArrayList<String> result = new ArrayList<String>();
        result=Result(result, words);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
        return w;
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
    public ArrayList<String> Result(ArrayList<String> result, String[] words){
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
}
