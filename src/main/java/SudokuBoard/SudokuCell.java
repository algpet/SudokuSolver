package SudokuBoard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SudokuCell {

    private Set<Integer> possibleValues;
    private Integer actualValue;

    public SudokuCell(Set<Integer> possibleValues){
        this.possibleValues = possibleValues;
        validate();
    }

    public SudokuCell(Integer actualValue){
        this.actualValue = actualValue;
        possibleValues = new HashSet<Integer>();
        possibleValues.add(actualValue);
        validate();
    }

    public void removeIllegalValue(Integer illegalValue){
        possibleValues.remove(illegalValue);
        validate();
    }

    private void validate(){
        if(actualValue == null){
            if(possibleValues.size()==1){
                for (Integer possibleValue : possibleValues) {
                    actualValue = possibleValue;
                }
            }
        }
        else{
            if(possibleValues.size()!=1){
                throw new IllegalStateException();
            }
        }
    }

    public Set<Integer> getPossibleValues(){
        return this.possibleValues;
    }

    public Integer value(){
        return actualValue;
    }

    public boolean canBe(Integer value){
        return possibleValues.contains(value);
    }

    public String toString(){

        if(actualValue == null){
            return getPossibleValues().toString();
        }
        else{
            return actualValue.toString();
        }
    }

}
