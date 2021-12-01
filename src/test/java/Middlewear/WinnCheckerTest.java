package Middlewear;

import BackendObjects.Drawing;
import BackendObjects.Tipp;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class WinnCheckerTest {

    @BeforeEach
    public void setUp(){

    }

    @Test
    public void checkTheWinnClass01(){
        Tipp testTipp = new Tipp(new String[]{"1", "2", "3", "4", "5", "6"}, "1", "0", "0");
        Drawing testDrawing = new Drawing("0", new String[]{"1", "2", "3", "4", "5", "6"}, "1", "11.11.1111");

        String winnerClass = WinnChecker.getWinnerClass(testTipp, testDrawing);

        assertEquals("GK 1", winnerClass);
    }

    @Test
    public void checkTheWinnClass02(){
        Tipp testTipp = new Tipp(new String[]{"1", "2", "3", "4", "5", "6"}, "1", "0", "0");
        Drawing testDrawing = new Drawing("0", new String[]{"1", "2", "3", "4", "5", "6"}, "2", "11.11.1111");

        String winnerClass = WinnChecker.getWinnerClass(testTipp, testDrawing);

        assertEquals("GK 2", winnerClass);
    }

    @Test
    public void checkTheWinnClass03(){
        Tipp testTipp = new Tipp(new String[]{"1", "2", "3", "4", "5", "7"}, "1", "0", "0");
        Drawing testDrawing = new Drawing("0", new String[]{"1", "2", "3", "4", "5", "6"}, "1", "11.11.1111");

        String winnerClass = WinnChecker.getWinnerClass(testTipp, testDrawing);

        assertEquals("GK 3", winnerClass);
    }

    @Test
    public void checkTheWinnClass04(){
        Tipp testTipp = new Tipp(new String[]{"1", "2", "3", "4", "5", "7"}, "1", "0", "0");
        Drawing testDrawing = new Drawing("0", new String[]{"1", "2", "3", "4", "5", "6"}, "2", "11.11.1111");

        String winnerClass = WinnChecker.getWinnerClass(testTipp, testDrawing);

        assertEquals("GK 4", winnerClass);
    }

    @Test
    public void checkTheWinnClass05(){
        Tipp testTipp = new Tipp(new String[]{"1", "2", "3", "4", "7", "8"}, "1", "0", "0");
        Drawing testDrawing = new Drawing("0", new String[]{"1", "2", "3", "4", "5", "6"}, "1", "11.11.1111");

        String winnerClass = WinnChecker.getWinnerClass(testTipp, testDrawing);

        assertEquals("GK 5", winnerClass);
    }

    @Test
    public void checkTheWinnClass06(){
        Tipp testTipp = new Tipp(new String[]{"1", "2", "3", "4", "7", "8"}, "1", "0", "0");
        Drawing testDrawing = new Drawing("0", new String[]{"1", "2", "3", "4", "5", "6"}, "2", "11.11.1111");

        String winnerClass = WinnChecker.getWinnerClass(testTipp, testDrawing);

        assertEquals("GK 6", winnerClass);
    }

    @Test
    public void checkTheWinnClass07(){
        Tipp testTipp = new Tipp(new String[]{"1", "2", "3", "7", "8", "9"}, "1", "0", "0");
        Drawing testDrawing = new Drawing("0", new String[]{"1", "2", "3", "4", "5", "6"}, "1", "11.11.1111");

        String winnerClass = WinnChecker.getWinnerClass(testTipp, testDrawing);

        assertEquals("GK 7", winnerClass);
    }

    @Test
    public void checkTheWinnClass08(){
        Tipp testTipp = new Tipp(new String[]{"1", "2", "3", "7", "8", "9"}, "1", "0", "0");
        Drawing testDrawing = new Drawing("0", new String[]{"1", "2", "3", "4", "5", "6"}, "2", "11.11.1111");

        String winnerClass = WinnChecker.getWinnerClass(testTipp, testDrawing);

        assertEquals("GK 8", winnerClass);
    }

    @Test
    public void checkTheWinnClass09(){
        Tipp testTipp = new Tipp(new String[]{"1", "2", "7", "8", "9", "10"}, "1", "0", "0");
        Drawing testDrawing = new Drawing("0", new String[]{"1", "2", "3", "4", "5", "6"}, "1", "11.11.1111");

        String winnerClass = WinnChecker.getWinnerClass(testTipp, testDrawing);

        assertEquals("GK 9", winnerClass);
    }


}