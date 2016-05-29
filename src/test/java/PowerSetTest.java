import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;
import SudokuSolvingStrategies.Utils.*;

import static org.junit.Assert.*;

public class PowerSetTest {

    private  Set<Integer> set;
    private  Set<Integer> set1;
    private  Set<Integer> set2;
    private  Set<Integer> set4;
    private  Set<Integer> set12;
    private  Set<Integer> set14;
    private  Set<Integer> set24;
    private  Set<Integer> set124;

    private PowerSet<Integer> powerSet;

    @Before
    public void before(){
        set = new HashSet<Integer>();

        set1 = new HashSet<Integer>();
        set1.add(1);

        set2 = new HashSet<Integer>();
        set2.add(2);

        set4 = new HashSet<Integer>();
        set4.add(4);

        set12 = new HashSet<Integer>();
        set12.add(1);
        set12.add(2);

        set14 = new HashSet<Integer>();
        set14.add(1);
        set14.add(4);

        set24 = new HashSet<Integer>();
        set24.add(2);
        set24.add(4);

        set124 = new HashSet<Integer>();
        set124.add(1);
        set124.add(2);
        set124.add(4);

    }

    @Test
    public void testEmptySet(){
        powerSet = new PowerSet<>(set);
        assertEquals(1 , powerSet.getPowerSet().size());

    }

    @Test
    public void testSetWithOneElement(){
        powerSet = new PowerSet<>(set1);
        assertEquals(2 , powerSet.getPowerSet().size());
        assertTrue(powerSet.getPowerSet().contains(set1));
        assertTrue(powerSet.getPowerSet().contains(set));
    }

    @Test
    public void testSetWithTwoElements(){
        powerSet = new PowerSet<>(set24);
        assertEquals(4 , powerSet.getPowerSet().size());
        assertTrue(powerSet.getPowerSet().contains(set24));
        assertTrue(powerSet.getPowerSet().contains(set2));
        assertTrue(powerSet.getPowerSet().contains(set4));
        assertTrue(powerSet.getPowerSet().contains(set));
    }

    @Test
    public void testSetWithThreeElements(){
        powerSet = new PowerSet<>(set124);
        assertEquals(8 , powerSet.getPowerSet().size());

        assertTrue(powerSet.getPowerSet().contains(set124));
        assertTrue(powerSet.getPowerSet().contains(set12));
        assertTrue(powerSet.getPowerSet().contains(set14));
        assertTrue(powerSet.getPowerSet().contains(set24));
        assertTrue(powerSet.getPowerSet().contains(set1));
        assertTrue(powerSet.getPowerSet().contains(set2));
        assertTrue(powerSet.getPowerSet().contains(set4));
        assertTrue(powerSet.getPowerSet().contains(set));
    }

    @Test
    public void testSubsetOfSize(){
        powerSet = new PowerSet<>(set124);
        Set<Set<Integer>> subsetsOf2 = powerSet.getSubsetsOfSize(2);
        assertEquals(3 , subsetsOf2.size());
        assertTrue(subsetsOf2.contains(set12));
        assertTrue(subsetsOf2.contains(set14));
        assertTrue(subsetsOf2.contains(set24));

    }

}
