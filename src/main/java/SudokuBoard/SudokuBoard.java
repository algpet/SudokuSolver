package SudokuBoard;

import SudokuSolvingStrategies.SudokuSolvingStrategies;
import SudokuSolvingStrategies.SudokuSolvingStrategy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SudokuBoard {
    private SudokuCell[][] sudoku;
    private List<SudokuCellGroup> rowGroups;
    private List<SudokuCellGroup> colGroups;
    private List<SudokuCellGroup> boxGroups;
    private List<SudokuCellGroup> allGroups;

    private int dimension;
    private List<Integer> initialState;
    private int boxw;
    private int boxh;

    private SudokuSolvingStrategies strategies = new SudokuSolvingStrategies();

    public SudokuBoard(int dimension , List<Integer> initialState , int boxw , int boxh) throws IllegalArgumentException{

        if(initialState == null)
            throw new IllegalArgumentException("initialState is null");
        if(initialState.size() < dimension * dimension)
            throw new IllegalArgumentException("initialState is not long enough");
        if(boxw*boxh != dimension)
            throw new IllegalArgumentException("incorrect box size");

        this.dimension = dimension;
        this.initialState = initialState;
        this.boxh = boxh;
        this.boxw = boxw;

        setupBoard();
        createGroups();
    }

    private boolean isSolved(){
        for(int h = 0; h < dimension; h++ ){
            for(int w = 0 ; w < dimension; w++){
                if(sudoku[h][w].value() == null)
                    return false;
            }
        }
        return true;
    }

    public void solve(){
        boolean result = true;
        System.out.println(this.toString());
        try {
            while (result) {
                result = false;
                for (SudokuSolvingStrategy strategy : strategies) {
                    result = strategy.applyStrategy(allGroups);
                    System.out.println(strategy + " " + result);
                    if (result)
                        break;
                }
                if (isSolved())
                    break;
            }
            System.out.println(this.toString());
        }
        catch (Exception e){
            System.out.println("Crush !");
            System.out.println(this.solution());
            for(int h = 0; h < dimension; h++ ){
                for(int w = 0 ; w < dimension; w++){
                    if(sudoku[h][w].value() != null && sudoku[h][w].getPossibleValues().size() != 1 ) {
                        System.out.println("Wrong state at " + h + " " + w + " : " + sudoku[h][w] + " " + sudoku[h][w].getPossibleValues() );
                    }
                }
            }
            System.out.println("Crush !");
        }
    }


    private void setupBoard(){
        sudoku = new SudokuCell[this.dimension][this.dimension];
        int i = 0;
        for(int h = 0; h < dimension; h++ ){
            for(int w = 0 ; w < dimension; w++){
                Integer value = initialState.get(i);
                if(value == null || value < 1 || value > dimension){
                    Set values = new HashSet();
                    for(int v = 1 ; v <= dimension;v++ )
                        values.add(v);
                    sudoku[h][w] = new SudokuCell(values);
                }
                else{
                    sudoku[h][w] = new SudokuCell(value);
                }
                i++;
            }
        }
    }

    private void createGroups(){
        rowGroups = new ArrayList<SudokuCellGroup>();
        colGroups = new ArrayList<SudokuCellGroup>();
        boxGroups = new ArrayList<SudokuCellGroup>();
        allGroups = new ArrayList<SudokuCellGroup>();

        for(int d = 0; d < dimension; d++ ){
            SudokuCellGroup row = new SudokuCellGroup(SudokuCellGroup.GroupType.ROW);
            rowGroups.add(row);
            SudokuCellGroup col = new SudokuCellGroup(SudokuCellGroup.GroupType.COLUMN);
            colGroups.add(col);
            SudokuCellGroup box = new SudokuCellGroup(SudokuCellGroup.GroupType.BOX);
            boxGroups.add(box);
        }

        int boxCountInRow = dimension / boxw;
        for(int row = 0; row < dimension; row++ ){
            for(int col = 0; col < dimension;col++){
                rowGroups.get(row).add(sudoku[row][col]);
                colGroups.get(col).add(sudoku[row][col]);
                int boxIndex = (row / boxh) * boxCountInRow + (col / boxw);
                boxGroups.get(boxIndex).add(sudoku[row][col]);
            }
        }
        allGroups.addAll(rowGroups);
        allGroups.addAll(colGroups);
        allGroups.addAll(boxGroups);
    }

    public String solution(){
        String solution = "";
        for(int row = 0; row < dimension; row++ ) {
            for (int col = 0; col < dimension; col++) {
                solution += sudoku[row][col].toString()+ "-";
            }
        }

        return solution.substring(0,solution.length()-1);
    }

    public String toString(){
        String board = "";
        for(int row = 0; row < dimension; row++ ) {
            for (int col = 0; col < dimension; col++) {
                Integer value = sudoku[row][col].value();
                if(value == null){
                    board += "?";
                }
                else{
                    board += value.toString();
                }
            }
            board += "\n";
        }
        board += "\n";
        return board;
    }

}
