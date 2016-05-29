package SudokuSolvingStrategies;

import SudokuBoard.SudokuCell;
import SudokuBoard.SudokuCellGroup;

import java.util.List;

public class IntersectionRemoval implements SudokuSolvingStrategy{

    public boolean applyStrategy(List<SudokuCellGroup> groups){
        boolean result = false;

        for (SudokuCellGroup box : groups) {
            if(!box.getGroupType().equals(SudokuCellGroup.GroupType.BOX))
                continue;

            for (SudokuCellGroup line : groups) {
                if(line.getGroupType().equals(SudokuCellGroup.GroupType.BOX))
                    continue;
                SudokuCellGroup commonCells = getCommonCells(box,line);
                if(commonCells.size() == 0)
                    continue;

                result = result || applyStrategy(box , line , commonCells);
            }
        }
        return result;
    }

    private SudokuCellGroup getCommonCells(SudokuCellGroup box, SudokuCellGroup line) {
        SudokuCellGroup commonCells = new SudokuCellGroup(SudokuCellGroup.GroupType.OTHER);
        for (SudokuCell boxCell : box) {
            for (SudokuCell lineCell : line) {
                if(boxCell.equals(lineCell)){
                    commonCells.add(lineCell);
                }
            }
        }
        return commonCells;
    }

    public boolean applyStrategy(SudokuCellGroup box , SudokuCellGroup line , SudokuCellGroup commonCells){
        boolean result = false;
        for(int n = 1; n <= box.size() ; n++ ){
            int commonPopularity = popularityIndex(n,commonCells);
            if(commonPopularity<2)
                continue;

            int boxPopularity = popularityIndex(n,box);
            int linePopularity = popularityIndex(n,line);

            if((boxPopularity > commonPopularity) == (linePopularity > commonPopularity))
                continue;

            result = true;

            if(boxPopularity > commonPopularity)
                cleanGroup(n,box,commonCells);
            if(linePopularity > commonPopularity)
                cleanGroup(n,line,commonCells);
        }
        return result;
    }

    public void cleanGroup(int number , SudokuCellGroup group , SudokuCellGroup commonCells){
        for (SudokuCell sudokuCell : group) {
            if(!commonCells.contains(sudokuCell)){
                sudokuCell.removeIllegalValue(number);
            }
        }
    }

    public int popularityIndex(int number , SudokuCellGroup group){
        int popularity = 0;
        for (SudokuCell sudokuCell : group) {
            if(sudokuCell.canBe(number))
                popularity++;
        }
        return popularity;
    }

    @Override
    public String toString(){
        return this.getClass().toString();
    }

}
