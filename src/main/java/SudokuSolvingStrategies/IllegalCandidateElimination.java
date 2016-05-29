package SudokuSolvingStrategies;

import SudokuBoard.SudokuCellGroup;
import java.util.List;

class IllegalCandidateElimination implements SudokuSolvingStrategy {

    public boolean applyStrategy(List<SudokuCellGroup> groups){
        boolean result = false;
        for (SudokuCellGroup group : groups) {
            result = result || applyStrategy(group);
        }
        return result;
    }

    public boolean applyStrategy(SudokuCellGroup group){
        boolean result = false;
        for (int i = 0; i < group.size(); i++) {
            Integer value = group.get(i).value();
            if(value == null)
                continue;

            for(int j = 0 ; j < group.size() ; j++){
                if(i==j)
                    continue;
                if(group.get(j).canBe(value)){
                    result = true;
                    group.get(j).removeIllegalValue(value);
                }
            }
        }
        return result;
    }

    @Override
    public String toString(){
        return this.getClass().toString();
    }

}
