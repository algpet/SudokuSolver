import SudokuBoard.SudokuBoard;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SudokuBoardTest {

    @Test
    public void applyToTestCases(){

        /*
        assertEquals("2-3-4-1-1-4-3-2-4-2-1-3-3-1-2-4" , graycellru2x2_example().solution());
        assertEquals("4-1-3-2-2-3-1-4-3-4-2-1-1-2-4-3" , graycellru2x2_26().solution());
        assertEquals("1-2-3-4-3-4-1-2-4-1-2-3-2-3-4-1" , graycellru2x2_25().solution());
        assertEquals("4-1-3-2-3-2-1-4-1-4-2-3-2-3-4-1" , graycellru2x2_24().solution());
        assertEquals("3-4-1-2-2-1-3-4-1-2-4-3-4-3-2-1" , graycellru2x2_23().solution());
        assertEquals("4-2-3-1-3-1-4-2-1-4-2-3-2-3-1-4" , graycellru2x2_22().solution());
        assertEquals("1-2-3-4-3-4-1-2-4-3-2-1-2-1-4-3" , graycellru2x2_21().solution());
        assertEquals("1-3-4-2-2-4-3-1-4-1-2-3-3-2-1-4" , graycellru2x2_20().solution());
        assertEquals("1-4-3-2-3-2-1-4-4-1-2-3-2-3-4-1" , graycellru2x2_19().solution());
        assertEquals("4-1-2-3-2-3-4-1-1-2-3-4-3-4-1-2" , graycellru2x2_18().solution());
        assertEquals("4-2-3-1-3-1-2-4-1-3-4-2-2-4-1-3" , graycellru2x2_17().solution());
        */

        assertEquals("4-6-3-1-8-2-9-7-5-5-8-7-4-6-9-1-2-3-9-2-1-3-5-7-8-6-4-2-4-8-6-7-1-3-5-9-7-5-9-2-4-3-6-1-8-1-3-6-5-9-8-7-4-2-3-7-5-9-2-6-4-8-1-8-1-4-7-3-5-2-9-6-6-9-2-8-1-4-5-3-7" ,
                graycellru3x3_A().solution());

        /*following two are same shit*/
        assertEquals( "4-6-1-5-7-2-9-3-8-7-3-2-8-9-4-1-5-6-8-9-5-3-1-6-2-4-7-3-7-8-6-2-9-5-1-4-5-2-9-4-8-1-6-7-3-6-1-4-7-5-3-8-9-2-9-5-7-2-4-8-3-6-1-1-8-3-9-6-7-4-2-5-2-4-6-1-3-5-7-8-9" ,
                sudokuWikiNakedCandidatesExampleWithRedsAndBlues().solution() );
        assertEquals( "4-6-1-5-7-2-9-3-8-7-3-2-8-9-4-1-5-6-8-9-5-3-1-6-2-4-7-3-7-8-6-2-9-5-1-4-5-2-9-4-8-1-6-7-3-6-1-4-7-5-3-8-9-2-9-5-7-2-4-8-3-6-1-1-8-3-9-6-7-4-2-5-2-4-6-1-3-5-7-8-9" ,
                sudokuWikiNakedCandidatesExampleWithRedsOnly().solution() );

        /*hidden pair A*/
        assertEquals( "5-8-3-2-1-9-4-6-7-9-1-4-6-3-7-8-2-5-2-7-6-8-5-4-1-3-9-3-4-9-7-2-1-5-8-6-7-2-8-9-6-5-3-4-1-6-5-1-3-4-8-7-9-2-4-9-7-5-8-2-6-1-3-1-6-5-4-9-3-2-7-8-8-3-2-1-7-6-9-5-4" ,
                sudokuWikiHiddenPairsExampleA().solution());

        // hidden pair works here but not enougth to solve it
        // sudokuWikiHiddenPairsExampleB().solution();

        /*hidden triple*/
        assertEquals( "8-9-4-5-7-1-6-3-2-2-3-1-6-9-8-4-5-7-7-6-5-2-4-3-1-9-8-6-7-8-9-2-4-3-1-5-1-4-3-8-5-7-9-2-6-9-5-2-1-3-6-7-8-4-4-8-9-3-6-2-5-7-1-5-2-6-7-1-9-8-4-3-3-1-7-4-8-5-2-6-9" ,
                sudokuWikiHiddenTriplesExample().solution());

         /*naked quad*/
        assertEquals( "1-4-2-5-3-9-7-8-6-5-8-7-6-2-1-9-4-3-6-9-3-4-7-8-5-2-1-3-7-1-8-5-6-2-9-4-9-6-8-1-4-2-3-7-5-4-2-5-3-9-7-6-1-8-2-1-4-7-6-3-8-5-9-8-3-9-2-1-5-4-6-7-7-5-6-9-8-4-1-3-2" ,
                sudokuWikiNakedQuadsExample().solution());

        /*hidden quad A - unable to solve with just reds*/
        //SudokuBoard board = sudokuWikiHiddenQuadsExampleA();
        //System.out.println(board.solution());

        /*hidden quad B*/
        /*hidden quad works but not enougth to solve*/
        //sudokuWikiHiddenQuadsExampleB

        //int-removal works here
        //System.out.println(sudokuWikiIntersectionRemovalExampleA().solution());
        //System.out.println(sudokuWikiIntersectionRemovalExampleB().solution());
        // System.out.println(sudokuWikiIntersectionRemovalExampleC().solution());

    }

    @Test
    public void applyNew(){
        /*hidden quad B*/
        System.out.println(sudokuWikiIntersectionRemovalExampleC().solution());
    }

    public SudokuBoard graycellru2x2_example(){
        List<Integer> state = new ArrayList<Integer>();
        state.add(2);state.add(null);state.add(null);state.add(null);
        state.add(null);state.add(null);state.add(3);state.add(null);
        state.add(null);state.add(null);state.add(null);state.add(null);
        state.add(null);state.add(1);state.add(null);state.add(4);

        SudokuBoard board = new SudokuBoard(4 ,state , 2 , 2);
        board.solve();
        return board;
    }
    public SudokuBoard graycellru2x2_26(){
        List<Integer> state = new ArrayList<Integer>();
        state.add(null);state.add(1);state.add(null);state.add(null);
        state.add(null);state.add(null);state.add(null);state.add(4);
        state.add(3);state.add(null);state.add(2);state.add(null);
        state.add(null);state.add(null);state.add(null);state.add(null);

        SudokuBoard board = new SudokuBoard(4 ,state , 2 , 2);
        board.solve();
        return board;
    }
    public SudokuBoard graycellru2x2_25(){
        List<Integer> state = new ArrayList<Integer>();
        state.add(null);state.add(null);state.add(3);state.add(null);
        state.add(null);state.add(null);state.add(null);state.add(2);
        state.add(null);state.add(null);state.add(null);state.add(null);
        state.add(null);state.add(3);state.add(4);state.add(null);

        SudokuBoard board = new SudokuBoard(4 ,state , 2 , 2);
        board.solve();
        return board;
    }
    public SudokuBoard graycellru2x2_24(){
        List<Integer> state = new ArrayList<Integer>();
        state.add(null);state.add(null);state.add(null);state.add(null);
        state.add(null);state.add(2);state.add(1);state.add(null);
        state.add(1);state.add(null);state.add(null);state.add(3);
        state.add(null);state.add(null);state.add(null);state.add(null);

        SudokuBoard board = new SudokuBoard(4 ,state , 2 , 2);
        board.solve();
        return board;
    }
    public SudokuBoard graycellru2x2_23(){
        List<Integer> state = new ArrayList<Integer>();
        state.add(null);state.add(4);state.add(null);state.add(2);
        state.add(null);state.add(null);state.add(null);state.add(null);
        state.add(1);state.add(null);state.add(4);state.add(null);
        state.add(null);state.add(null);state.add(null);state.add(null);

        SudokuBoard board = new SudokuBoard(4 ,state , 2 , 2);
        board.solve();
        return board;
    }
    public SudokuBoard graycellru2x2_22(){
        List<Integer> state = new ArrayList<Integer>();
        state.add(null);state.add(null);state.add(null);state.add(null);
        state.add(3);state.add(null);state.add(null);state.add(2);
        state.add(null);state.add(4);state.add(null);state.add(null);
        state.add(null);state.add(null);state.add(1);state.add(null);

        SudokuBoard board = new SudokuBoard(4 ,state , 2 , 2);
        board.solve();
        return board;
    }
    public SudokuBoard graycellru2x2_21(){
        List<Integer> state = new ArrayList<Integer>();
        state.add(1);state.add(2);state.add(null);state.add(null);
        state.add(3);state.add(null);state.add(null);state.add(null);
        state.add(null);state.add(null);state.add(null);state.add(1);
        state.add(null);state.add(null);state.add(4);state.add(null);

        SudokuBoard board = new SudokuBoard(4 ,state , 2 , 2);
        board.solve();
        return board;
    }
    public SudokuBoard graycellru2x2_20(){
        List<Integer> state = new ArrayList<Integer>();
        state.add(null);state.add(null);state.add(4);state.add(2);
        state.add(null);state.add(null);state.add(null);state.add(null);
        state.add(null);state.add(null);state.add(null);state.add(3);
        state.add(null);state.add(2);state.add(null);state.add(null);

        SudokuBoard board = new SudokuBoard(4 ,state , 2 , 2);
        board.solve();
        return board;
    }
    public SudokuBoard graycellru2x2_19(){
        List<Integer> state = new ArrayList<Integer>();
        state.add(1);state.add(null);state.add(null);state.add(null);
        state.add(null);state.add(null);state.add(null);state.add(4);
        state.add(null);state.add(null);state.add(2);state.add(null);
        state.add(null);state.add(3);state.add(null);state.add(null);

        SudokuBoard board = new SudokuBoard(4 ,state , 2 , 2);
        board.solve();
        return board;
    }
    public SudokuBoard graycellru2x2_18(){
        List<Integer> state = new ArrayList<Integer>();
        state.add(null);state.add(null);state.add(2);state.add(3);
        state.add(null);state.add(null);state.add(null);state.add(null);
        state.add(1);state.add(2);state.add(null);state.add(null);
        state.add(null);state.add(null);state.add(null);state.add(null);

        SudokuBoard board = new SudokuBoard(4 ,state , 2 , 2);
        board.solve();
        return board;
    }
    public SudokuBoard graycellru2x2_17(){
        Integer[][] init = new Integer[][]
                {
                        {0,2,0,0},
                        {0,0,0,4},
                        {1,0,0,0},
                        {0,0,1,0},
                };

        SudokuBoard board = new SudokuBoard(4 ,listFrom2D(init) , 2 , 2);
        board.solve();
        return board;
    }

    public SudokuBoard graycellru3x3_A(){
        Integer[][] init = new Integer[][]
                {
                        {4,0,3 ,0,0,2 ,0,0,0},
                        {5,0,0 ,0,6,0 ,1,2,0},
                        {9,0,0 ,0,0,0 ,0,0,4},

                        {0,0,8 ,0,7,0 ,0,0,0},
                        {0,0,0 ,2,0,3 ,0,0,8},
                        {0,3,6 ,0,0,0 ,7,0,0},

                        {0,7,0 ,9,2,0 ,0,0,0},
                        {0,0,0 ,0,0,5 ,0,9,6},
                        {0,0,0 ,8,0,4 ,5,0,0},
                };
        SudokuBoard board = new SudokuBoard(9 ,listFrom2D(init) , 3 , 3);
        board.solve();
        return board;
    }


    public SudokuBoard sudokuWikiNakedCandidatesExampleWithoutReds(){
        Integer[][] init = new Integer[][]
                {
                        {0,0,0 ,0,0,0 ,9,0,0},
                        {0,3,0 ,0,9,0 ,0,0,0},
                        {0,9,0 ,0,0,0 ,0,0,0},

                        {3,0,0 ,0,0,0 ,0,0,0},
                        {5,0,9 ,0,0,1 ,6,0,3},
                        {0,0,4 ,0,0,0 ,0,0,0},

                        {9,0,0 ,0,0,0 ,0,0,0},
                        {0,0,0 ,0,0,0 ,0,0,0},
                        {0,0,0 ,0,3,0 ,7,0,0},
                };
        SudokuBoard board = new SudokuBoard(9 ,listFrom2D(init) , 3 , 3);
        board.solve();
        return board;
    }
    public SudokuBoard sudokuWikiNakedCandidatesExampleWithRedsAndBlues(){
        Integer[][] init = new Integer[][]
                {
                        {4,0,0 ,0,0,0 ,9,3,8},
                        {0,3,2 ,0,9,4 ,1,0,0},
                        {0,9,5 ,3,0,0 ,2,4,0},

                        {3,7,0 ,6,0,9 ,0,0,4},
                        {5,2,9 ,0,0,1 ,6,7,3},
                        {6,0,4 ,7,0,3 ,0,9,0},

                        {9,5,7 ,0,0,8 ,3,0,0},
                        {0,0,3 ,9,0,0 ,4,0,0},
                        {2,4,0 ,0,3,0 ,7,0,9},
                };
        SudokuBoard board = new SudokuBoard(9 ,listFrom2D(init) , 3 , 3);
        board.solve();
        return board;
    }
    public SudokuBoard sudokuWikiNakedCandidatesExampleWithRedsOnly(){
        Integer[][] init = new Integer[][]
                {
                        {4,0,0 ,0,0,0 ,0,3,8},
                        {0,0,2 ,0,0,4 ,1,0,0},
                        {0,0,5 ,3,0,0 ,2,4,0},

                        {0,7,0 ,6,0,9 ,0,0,4},
                        {0,2,0 ,0,0,0 ,0,7,0},
                        {6,0,0 ,7,0,3 ,0,9,0},

                        {0,5,7 ,0,0,8 ,3,0,0},
                        {0,0,3 ,9,0,0 ,4,0,0},
                        {2,4,0 ,0,0,0 ,0,0,9},
                };
        SudokuBoard board = new SudokuBoard(9 ,listFrom2D(init) , 3 , 3);
        board.solve();
        return board;
    }
    public SudokuBoard sudokuWikiNakedQuadsExample(){
        Integer[][] init = new Integer[][]
                {
                        {0,0,0 ,0,3,0 ,0,8,6},
                        {0,0,0 ,0,2,0 ,0,0,0},
                        {0,0,0 ,0,0,8 ,5,0,0},

                        {3,7,1 ,0,0,0 ,0,9,4},
                        {9,0,0 ,0,0,0 ,0,0,5},
                        {4,0,0 ,0,0,7 ,6,0,0},

                        {2,0,0 ,7,0,0 ,8,0,0},
                        {0,3,0 ,0,0,5 ,0,0,0},
                        {7,0,0 ,0,0,4 ,0,3,0},
                };
        SudokuBoard board = new SudokuBoard(9 ,listFrom2D(init) , 3 , 3);
        board.solve();
        return board;
    }
    public SudokuBoard sudokuWikiHiddenPairsExampleA(){
        Integer[][] init = new Integer[][]
                {
                        {0,0,0 ,0,0,0 ,0,0,0},
                        {9,0,4 ,6,0,7 ,0,0,0},
                        {0,7,6 ,8,0,4 ,1,0,0},

                        {3,0,9 ,7,0,1 ,0,8,0},
                        {0,0,8 ,0,0,0 ,3,0,0},
                        {0,5,0 ,3,0,8 ,7,0,2},

                        {0,0,7 ,5,0,2 ,6,1,0},
                        {0,0,0 ,4,0,3 ,2,0,8},
                        {0,0,0 ,0,0,0 ,0,0,0},
                };
        SudokuBoard board = new SudokuBoard(9 ,listFrom2D(init) , 3 , 3);
        board.solve();
        return board;
    }
    public SudokuBoard sudokuWikiHiddenPairsExampleB(){
        Integer[][] init = new Integer[][]
                {
                        {7,2,0 ,4,0,0 ,0,3,0},
                        {0,0,0 ,0,0,0 ,0,4,7},
                        {0,0,1 ,0,7,6 ,8,0,2},

                        {0,1,0 ,0,3,9 ,0,0,0},
                        {0,0,0 ,8,0,1 ,0,0,0},
                        {0,0,0 ,2,6,0 ,0,8,0},

                        {2,0,9 ,6,8,0 ,4,0,0},
                        {3,4,0 ,0,0,0 ,0,0,0},
                        {0,6,0 ,0,0,3 ,0,7,5},
                };
        SudokuBoard board = new SudokuBoard(9 ,listFrom2D(init) , 3 , 3);
        board.solve();
        return board;
    }
    public SudokuBoard sudokuWikiHiddenTriplesExample(){
        Integer[][] init = new Integer[][]
                {
                        {0,0,0 ,0,0,0 ,0,0,0},
                        {2,3,1 ,0,9,0 ,0,0,0},
                        {0,6,5 ,0,0,3 ,1,0,0},

                        {0,0,8 ,9,2,4 ,0,0,0},
                        {1,0,0 ,0,5,0 ,0,0,6},
                        {0,0,0 ,1,3,6 ,7,0,0},

                        {0,0,9 ,3,0,0 ,5,7,0},
                        {0,0,0 ,0,1,0 ,8,4,3},
                        {0,0,0 ,0,0,0 ,0,0,0},
                };
        SudokuBoard board = new SudokuBoard(9 ,listFrom2D(init) , 3 , 3);
        board.solve();
        return board;
    }
    public SudokuBoard sudokuWikiHiddenQuadsExampleA(){
        Integer[][] init = new Integer[][]
                {
                        {6,5,0 ,0,0,0 ,0,2,4},
                        {0,0,0 ,6,0,9 ,0,0,0},
                        {0,4,0 ,0,0,0 ,0,0,0},

                        {5,7,0 ,4,0,0 ,0,6,1},
                        {0,0,0 ,5,0,1 ,0,0,0},
                        {3,1,0 ,0,0,2 ,0,8,5},

                        {0,0,0 ,0,0,0 ,0,1,0},
                        {0,0,0 ,2,0,3 ,0,0,0},
                        {1,3,0 ,0,0,0 ,0,9,8},
                };
        SudokuBoard board = new SudokuBoard(9 ,listFrom2D(init) , 3 , 3);
        board.solve();
        return board;
    }
    public SudokuBoard sudokuWikiHiddenQuadsExampleB(){
        Integer[][] init = new Integer[][]
                {
                        {0,0,0 ,5,0,0 ,0,0,0},
                        {4,2,5 ,0,9,0 ,0,0,1},
                        {8,0,0 ,0,1,0 ,0,2,0},

                        {5,0,0 ,0,0,0 ,0,0,0},
                        {0,1,9 ,0,0,0 ,4,6,0},
                        {0,0,0 ,0,0,0 ,0,0,2},

                        {0,9,0 ,0,4,0 ,0,0,3},
                        {2,0,0 ,0,6,0 ,8,0,7},
                        {0,0,0 ,0,0,1 ,6,0,0},
                };
        SudokuBoard board = new SudokuBoard(9 ,listFrom2D(init) , 3 , 3);
        board.solve();
        return board;
    }
    public SudokuBoard sudokuWikiIntersectionRemovalExampleA(){
        Integer[][] init = new Integer[][]
                {
                        {0,1,0 ,9,0,3 ,6,0,0},
                        {0,0,0 ,0,8,0 ,0,0,0},
                        {9,0,0 ,0,0,0 ,5,0,7},

                        {0,0,2 ,0,1,0 ,4,3,0},
                        {0,0,0 ,4,0,2 ,0,0,0},
                        {0,6,4 ,0,7,0 ,2,0,0},

                        {7,0,1 ,0,0,0 ,0,0,5},
                        {0,0,0 ,0,3,0 ,0,0,0},
                        {0,0,5 ,6,0,1 ,0,2,0},
                };
        SudokuBoard board = new SudokuBoard(9 ,listFrom2D(init) , 3 , 3);
        board.solve();
        return board;
    }
    public SudokuBoard sudokuWikiIntersectionRemovalExampleB(){
        Integer[][] init = new Integer[][]
                {
                        {0,3,2 ,0,0,6 ,1,0,0},
                        {4,1,0 ,0,0,0 ,0,0,0},
                        {0,0,0 ,9,0,1 ,0,0,0},

                        {5,0,0 ,0,9,0 ,0,0,4},
                        {0,6,0 ,0,0,0 ,0,7,0},
                        {3,0,0 ,0,2,0 ,0,0,5},

                        {0,0,0 ,5,0,8 ,0,0,0},
                        {0,0,0 ,0,0,0 ,0,1,9},
                        {0,0,7 ,0,0,0 ,8,6,0},
                };
        SudokuBoard board = new SudokuBoard(9 ,listFrom2D(init) , 3 , 3);
        board.solve();
        return board;
    }

    public SudokuBoard sudokuWikiIntersectionRemovalExampleC(){
        Integer[][] init = new Integer[][]
                {
                        {0,1,6 ,0,0,7 ,8,0,3},
                        {0,0,0 ,8,0,0 ,0,0,0},
                        {0,7,0 ,0,0,1 ,0,6,0},

                        {0,4,8 ,0,0,0 ,3,0,0},
                        {6,0,0 ,0,0,0 ,0,0,2},
                        {0,0,9 ,0,0,0 ,6,5,0},

                        {0,6,0 ,9,0,0 ,0,2,0},
                        {0,0,0 ,0,0,2 ,0,0,0},
                        {9,0,4 ,6,0,0 ,5,1,0},
                };
        SudokuBoard board = new SudokuBoard(9 ,listFrom2D(init) , 3 , 3);
        board.solve();
        return board;
    }

    public SudokuBoard zzzx(){
        Integer[][] init = new Integer[][]
                {
                        {0,0,0 ,0,0,0 ,0,0,0},
                        {0,0,0 ,0,0,0 ,0,0,0},
                        {0,0,0 ,0,0,0 ,0,0,0},

                        {0,0,0 ,0,0,0 ,0,0,0},
                        {0,0,0 ,0,0,0 ,0,0,0},
                        {0,0,0 ,0,0,0 ,0,0,0},

                        {0,0,0 ,0,0,0 ,0,0,0},
                        {0,0,0 ,0,0,0 ,0,0,0},
                        {0,0,0 ,0,0,0 ,0,0,0},
                };
        SudokuBoard board = new SudokuBoard(9 ,listFrom2D(init) , 3 , 3);
        board.solve();
        return board;
    }



    public List<Integer> listFrom2D(Integer[][] init){
        List<Integer> list = new ArrayList<>();
        for (Integer[] integers : init) {
            list.addAll(Arrays.asList(integers));
        }
        return list;
    }


}
