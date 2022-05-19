package searching;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {

        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader bf = new BufferedReader(new FileReader("C:/Users/User/IdeaProjects/PracticeOOP/src/main/resources/article.txt"));
            String str;
            while ((str = bf.readLine()) != null) {
                sb.append(str);
                sb.append("\n");
            }
            bf.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        File file = new File("C:/Users/User/IdeaProjects/PracticeOOP/src/main/resources/result1.txt");
        try {
            FileUtils.writeStringToFile(file, "nature - " + StringUtils.countMatches(sb, "nature") + "\n" +
                    "services - " + StringUtils.countMatches(sb, "services") + "\n" +
                    "oxygen - " + StringUtils.countMatches(sb, "oxygen"));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        /*
        try(FileWriter writer = new FileWriter("C:/Users/User/IdeaProjects/PracticeOOP/src/main/resources/result.txt", false))
        {
            String text = "nature - " + StringUtils.countMatches(sb , "nature");
            writer.write(text);
            writer.append('\n');
            String text2 = "services - " + StringUtils.countMatches(sb , "services");
            writer.write(text2);
            writer.append('\n');
            String text3 = "oxygen - " + StringUtils.countMatches(sb , "oxygen");
            writer.write(text3);
           // writer.append('E');

           // writer.flush();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }*/
    }
}
