package SudokuSolvingStrategies;

import java.util.ArrayList;

public class SudokuSolvingStrategies extends ArrayList<SudokuSolvingStrategy> {
    public SudokuSolvingStrategies(){
        super();
        this.add(new IllegalCandidateElimination());
        this.add(new HiddenSets(1));
        this.add(new NakedSets(2));
        this.add(new NakedSets(3));
        this.add(new HiddenSets(2));
        this.add(new HiddenSets(3));
        this.add(new NakedSets(4));
        this.add(new HiddenSets(4));
        this.add(new IntersectionRemoval());
        //this.add(new SudokuSolvingStrategies.NakedSets(4));
    }
}
