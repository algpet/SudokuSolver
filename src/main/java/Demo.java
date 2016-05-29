import SudokuBoard.SudokuBoard;

import java.util.ArrayList;
import java.util.List;

public class Demo {

    public static void main(String[] args){
        SudokuBoard board = sample2x2();
        System.out.println(board.solution());
        board.solve();
        System.out.println(board.solution());
    }

    public static SudokuBoard sample2x2(){
        List<Integer> state = new ArrayList<Integer>();
        state.add(2);state.add(null);state.add(null);state.add(null);
        state.add(null);state.add(null);state.add(3);state.add(null);
        state.add(null);state.add(null);state.add(null);state.add(null);
        state.add(null);state.add(1);state.add(null);state.add(4);

        SudokuBoard board = new SudokuBoard(4 ,state , 2 , 2);
        return board;
    }

}
