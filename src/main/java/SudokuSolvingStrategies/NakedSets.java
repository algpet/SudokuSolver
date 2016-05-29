package SudokuSolvingStrategies;
import SudokuBoard.SudokuCellGroup;
import SudokuBoard.SudokuCell;
import SudokuSolvingStrategies.Utils.PowerSet;

import java.util.List;
import java.util.Set;

class NakedSets implements SudokuSolvingStrategy {

    private int factor;
    public NakedSets(int factor){
        this.factor = factor;
    }

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
            SudokuCell cell = group.get(i);
            if(cell.value() != null)
                continue;
            Set<Integer> candidateSet = cell.getPossibleValues();
            if(candidateSet.size() != factor)
                continue;

            PowerSet<Integer> powerSet = new PowerSet<Integer>(candidateSet);

            int countOfEqualSets = 0;
            for (int j = 0; j < group.size(); j++) {
                if(candidateSet.equals(group.get(j).getPossibleValues())) {
                    countOfEqualSets++;
                }
                else if (factor > 2){
                    if(powerSet.getPowerSet().contains(group.get(j).getPossibleValues())) {
                        countOfEqualSets++;
                    }
                }
            }
            if(countOfEqualSets != factor)
                continue;

            for (int j = 0; j < group.size(); j++) {
                if(!powerSet.getPowerSet().contains(group.get(j).getPossibleValues())){
                    for ( Integer candidate : candidateSet) {
                        if(group.get(j).canBe(candidate)){
                            result = true;
                            group.get(j).removeIllegalValue(candidate);
                        }
                    }
                }
            }
        }
        return result;
    }

    @Override
    public String toString(){
        return this.getClass() + " " + factor;
    }

}
