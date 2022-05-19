import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.stub;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
//import org.testng.Assert;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.Mockito.*;
import org.mockito.Spy;
import org.mockito.InjectMocks;
import org.junit.runner.Runner;
import org.mockito.*;
//import org.mockito.junit.MockitoJUnit;
import java.io.FileNotFoundException;
import java.io.IOException;
//import org.mockito.junit.MockitoRule;

import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class WordsFilterTest {

    //@Rule public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    private DataAccessService mockedDI;

    @InjectMocks
    private WordsFilter wf;

    @Before
    public void doBeforeEachTestCase() {
        wf= new WordsFilter();
       // MockitoAnnotations.initMocks(this);
        wf.setDataAccess(mockedDI);
        //Mockito.when(mockedDI.Reader("text.txt")).thenReturn("fine");
        //Mockito.when(mockedDI.Reader("text2.txt")).thenReturn("ok");
        //Mockito.when(mockedDI.Reader("ttt.txt")).thenThrow(new FileNotFoundException());
        //MockitoAnnotations.initMocks(this);
        //wf.setDataAccess(mockedDI);
    }
    @Test
    public void Test1() throws IOException {
        //w.put("fine",1);
        //w.put("ok",1);
        //Assert.assertEquals(wf.Filter("text.txt"),w); // testNG
        Mockito.when(mockedDI.Reader("text.txt")).thenReturn("fine"); //1
        //Mockito.when(mockedDI.Reader(Mockito.eq("idValue"))).thenReturn("fine"); //1
        String val = wf.Filter("text.txt");
        Assert.assertEquals("fine", val); // testNG
         verify(mockedDI).Reader("text.txt");
    }






}
