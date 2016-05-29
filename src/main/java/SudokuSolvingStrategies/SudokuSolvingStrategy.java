package SudokuSolvingStrategies;
import SudokuBoard.SudokuCellGroup;
import java.util.List;

public interface SudokuSolvingStrategy {

    public boolean applyStrategy(List<SudokuCellGroup> groups);
    //public boolean applyStrategy(SudokuCellGroup group);
}
