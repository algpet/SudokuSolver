import SudokuBoard.SudokuCell;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class SudokuCellTest {

    public SudokuCell cell1;
    public SudokuCell cell4;
    public SudokuCell cell9;
    public SudokuCell solvedCell7;

    @Before
    public void before(){
        cell1 = newUnsolvedCell(1);
        cell4 = newUnsolvedCell(4);
        cell9 = newUnsolvedCell(9);
        solvedCell7 = new SudokuCell(7);
    }

    @Test
    public void cellIsUnsolvedWhenConstructedWithSetUnlessSetSizeIsOne(){
        assertEquals( new Integer(1) , cell1.value());
        assertNull(cell4.value());
        assertNull(cell9.value());
    }

    @Test
    public void cellCanBeAnythingWithinSetAfterConstructor(){
        for(int i = 1 ; i <=9;i++){
            assertTrue(cell9.canBe(i));
        }
        for(int i = 1 ; i <=4;i++){
            assertTrue(cell4.canBe(i));
        }
    }

    @Test
    public void cellCantBeSomethingOutOfSet(){
        for(int i = 10 ; i <=19;i++){
            assertFalse(cell9.canBe(i));
        }
        for(int i = 5 ; i <=19;i++){
            assertFalse(cell4.canBe(i));
        }
    }

    @Test
    public void removingIllegalRemovesItFromLegalValues(){
        assertTrue(cell4.canBe(2));
        cell4.removeIllegalValue(2);
        assertFalse(cell4.canBe(2));
    }

    @Test
    public void whenOnlySingleLegalvalueLeftCellBecomesSolved() {
        cell4.removeIllegalValue(2);
        cell4.removeIllegalValue(1);
        assertNull(cell4.value());
        cell4.removeIllegalValue(4);
        assertEquals(new Integer(3) , cell4.value());
    }

    @Test
    public void whenCreatedWithValueCellIsSolvedFromTheStart(){
        assertEquals(new Integer(7),solvedCell7.value());
        assertTrue(solvedCell7.canBe(7));
    }

    @Test(expected = IllegalStateException.class)
    public void removingOnlyLegalValueRaiseError(){
        cell4.removeIllegalValue(2);
        cell4.removeIllegalValue(1);
        cell4.removeIllegalValue(4);
        cell4.removeIllegalValue(3);
    }

    @Test(expected = IllegalStateException.class)
    public void removingOnlyLegalValueFromSolvedRaiseError(){
        solvedCell7.removeIllegalValue(7);
    }

    @Test
    public void canRemoveSameValueMultipleTimes(){
        cell4.removeIllegalValue(2);
        cell4.removeIllegalValue(2);
        cell4.removeIllegalValue(2);
        cell4.removeIllegalValue(2);
        assertTrue(cell4.canBe(1));
        assertTrue(cell4.canBe(3));
        assertFalse(cell4.canBe(2));
    }


    public SudokuCell newUnsolvedCell(Integer valuesTo){
        Set<Integer> set = new HashSet<Integer>();
        for(int i = 1 ; i <=valuesTo;i++) {
            set.add(i);
        }
        return new SudokuCell(set);
    }

}