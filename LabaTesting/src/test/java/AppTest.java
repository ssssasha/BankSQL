import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.nio.file.Paths;
import java.nio.file.Files;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.testng.Assert.*;
//import org.testng.reporters.Files;
import java.io.IOException;
import java.nio.file.Paths;
import java.io.*;
import java.util.*;
public class AppTest
{
    public static App app;

    @BeforeClass
    public static void setUpClass() throws IOException{
        System.out.println("before all");
        File file1 = new File("text1.txt");
        if (file1.createNewFile())
        {
            System.out.println("File is created!");
        } else {
            System.out.println("File already exists.");
        }
    }
    @AfterClass
    public static void afterClassMethod(){
        System.out.println("after all");
        File file1 = new File("text1.txt");
        file1.delete();
    }
    @BeforeMethod
    public void setUp(){
        System.out.println("before");
        try(FileWriter writer = new FileWriter("text1.txt", false))
        {

            String text = "kndfsfnd fjsdkfsdkfn vvvg smfsdnfsmndfmsjfndf smfsdnfsmndfmsjdddd";
            writer.write(text);
            writer.flush();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }
    @DataProvider(name="dataProviderMethod")
    public Object[][] data(){
        return new Object[][] {{"cnscnnc vnjdvn dd", new String[] {"cnscnnc", "vnjdvn", "dd"}},
                {"abc jdnvcjdn kkkpppp ckckckmkcs ncsc", new String[] {"abc", "jdnvcjdn", "kkkpppp", "ckckckmkcs", "ncsc"}}};
    }
    @DataProvider (name = "numberDataProviderMethod")
    public Object[][] getNumberData(){
        return new Object[][] {{"cnscnnc vnjdvn dd", 3}, {"abc jdnvcjdn kkkpppp ckckckmkcs ncsc", 5}, {"nvdjv bkbk aa fnd", 4}, {"acnkdnvkdn vjnnvvn", 2}};
    }
    @Test(dataProvider = "dataProviderMethod", groups = {"parametrized"})
    public void Test1( String data, String[] allWords) throws IOException {
        try(FileWriter writer = new FileWriter("text2.txt", false))
        {
            writer.write(data);
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
        String allW = new String(Files.readAllBytes(Paths.get("text2.txt")));
        String[] wwords = allW.split(" ");
        Assert.assertEquals(allWords, wwords);
        System.out.println("Test1");
    }
    @Test(dataProvider = "numberDataProviderMethod", groups = {"parametrized"})
    public void Test2( String numberData, int numberOfWords) throws IOException {
        try(FileWriter writer = new FileWriter("text2.txt", false))
        {
            writer.write(numberData);
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
        String allW = new String(Files.readAllBytes(Paths.get("text2.txt")));
        String[] wwords = allW.split(" ");
        Assert.assertEquals(numberOfWords, wwords.length );
        System.out.println("Test2");
    }

    @Test(groups = {"not-parametrized"})
    public void Test3()throws Exception
    {
        App app = new App();
        Assert.assertTrue( app.CutWord("bjkbkjbkjbjkbkjbjkbkjbkjbjnnkjbkjkj").length() == 30);
        System.out.println("Test3");
    }
    @Test(groups = {"not-parametrized"})
    public void Test4()throws Exception
    {
        App app = new App();
        Assert.assertEquals(app.CutWord("qwertyuiopasdfghjkzxcvbnmqwerty"), app.CutWord("qwertyuiopasdfghjkzxcvbnmqwertydax"));
        System.out.println("Test4");
    }
    @Test(groups = {"not-parametrized"})
    public void Test5()throws Exception
    {
        App app = new App();
        Assert.assertEquals(app.Filter("fl34o8w(e)r#"), app.Filter("f*l0ow@er"));
        System.out.println("Test5");
    }

    @Test(groups = {"not-parametrized"})
    public void Test6()throws Exception
    {
        App app = new App();
        String[] words = {"DNnknsks", "snfkndsfknsdf", "smfsdnfsmndfmsjfndf","smfsdnfsmndfmsjdddd"};
        ArrayList<String> result = new ArrayList<String>();
        Assert.assertTrue(App.Result(result,words).size() == 2);
        System.out.println("Test6");
    }

}

