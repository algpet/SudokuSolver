package SudokuBoard;

import SudokuBoard.SudokuCell;
import SudokuSolvingStrategies.SudokuSolvingStrategy;

import java.util.ArrayList;

public class SudokuCellGroup extends ArrayList<SudokuCell>{
    public enum GroupType {COLUMN , ROW , BOX ,OTHER}
    private GroupType groupType;

    public SudokuCellGroup(GroupType groupType){
        super();
        this.groupType = groupType;
    }

    public GroupType getGroupType(){
        return this.groupType;
    }

}
