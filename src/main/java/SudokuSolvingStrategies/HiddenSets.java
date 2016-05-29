package SudokuSolvingStrategies;

import SudokuBoard.SudokuCell;
import SudokuBoard.SudokuCellGroup;
import SudokuSolvingStrategies.Utils.PowerSet;

import java.util.*;

class HiddenSets implements SudokuSolvingStrategy {

    private int factor;
    public HiddenSets(int factor){
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

        Map<Integer,Integer> candidatePopularity = getCandidatePopularity(group);
        Set<Integer> candidatesOfFactor = filterCandidatesByFactor(candidatePopularity);
        if(candidatesOfFactor.size()< factor)
            return false;

        PowerSet powerSet = new PowerSet<Integer>(candidatesOfFactor);
        Set<Set<Integer>> subsetsOfCorrectFactor = powerSet.getSubsetsOfSize(factor);

        Set<Set<Integer>> hiddenSets = getHiddenSets(group , subsetsOfCorrectFactor);
        if(hiddenSets.size() == 0)
            return false;

        result = stripHiddenSets(group,hiddenSets);
        return result;
    }

    private boolean stripHiddenSets(SudokuCellGroup group , Set<Set<Integer>> hiddenSets){
        boolean result = false;
        for (Set<Integer> hiddenSet : hiddenSets) {
            for (SudokuCell sudokuCell : group) {
                if(sudokuCell.value() != null)
                    continue;

                boolean strip = false;
                for (Integer hiddenSetMember : hiddenSet) {
                    if(sudokuCell.canBe(hiddenSetMember)){
                        strip = true;
                        break;
                    }
                }
                if(!strip)
                    continue;

                for(int v = 1; v <= group.size() ; v++){
                    if(sudokuCell.canBe(v) && !hiddenSet.contains(v)){
                        sudokuCell.removeIllegalValue(v);
                        result = true;
                    }
                }
            }
        }
        return result;
    }

    private Set<Set<Integer>> getHiddenSets (SudokuCellGroup group , Set<Set<Integer>> candidateSets){
        Set<Set<Integer>> hiddenSets = new HashSet<Set<Integer>>();
        for (Set<Integer> hiddenSetCandidate : candidateSets) {
            int count = 0;
            for (SudokuCell sudokuCell : group) {

                for (Integer  hiddenSetCandidateElement : hiddenSetCandidate) {
                    if(sudokuCell.canBe(hiddenSetCandidateElement)){
                        count++;
                        break;
                    }
                }
            }
            if(count == factor)
                hiddenSets.add(hiddenSetCandidate);
        }
        return hiddenSets;
    }

    private Set<Integer> filterCandidatesByFactor(Map<Integer, Integer> candidatePopularity) {
        Set<Integer> candidatesWithCorrectFactor =  new HashSet<Integer>();
        for (Map.Entry<Integer, Integer> candidateEntry : candidatePopularity.entrySet()) {
            if(candidateEntry.getValue() <= factor){
                candidatesWithCorrectFactor.add(candidateEntry.getKey());
            }
        }
        return candidatesWithCorrectFactor;
    }

    private Map<Integer,Integer> getCandidatePopularity(SudokuCellGroup group){
        Map<Integer,Integer> candidatePopularity = new HashMap<Integer,Integer>();
        for(int c = 1 ; c<= group.size();c++ ){
            candidatePopularity.put(c,0);
        }

        for (SudokuCell sudokuCell : group) {
            if(sudokuCell.value() != null) {
                candidatePopularity.put(sudokuCell.value(),group.size()+1);
                continue;
            }
            Set<Integer> candidates = sudokuCell.getPossibleValues();
            for (Integer candidate : candidates) {
                candidatePopularity.put(candidate , candidatePopularity.get(candidate) + 1 );
            }
        }
        return candidatePopularity;
    }

    @Override
    public String toString(){
        return this.getClass() + " " + factor;
    }



}
