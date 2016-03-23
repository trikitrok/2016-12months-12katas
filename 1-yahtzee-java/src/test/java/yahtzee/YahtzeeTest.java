package yahtzee;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class YahtzeeTest {

    @Test
    public void testGame(){
        FakeConsole console = new FakeConsole();
        DieRoller dieRoller = mock(DieRoller.class);
        when(dieRoller.roll()).thenReturn(2, 4, 1, 6, 1);
        Yahtzee yahtzee = new Yahtzee(console, dieRoller);
        yahtzee.play();

        List<String> l = new ArrayList<String>();
        l.add("Category: Ones");
        l.add("Dice: D1:2 D2:4 D3:1 D4:6 D5:1");
        l.add("[1] Dice to re-run:");
        l.add("Dice: D1:1 D2:5 D3:1 D4:2 D5:1");
        assertEquals(l, console.getOutput());
    }

}