package SudokuSolvingStrategies.Utils;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PowerSet<V>{

    private Set<Set<V>> powerSet;

    public PowerSet(Set<V> originalSet){
        powerSet = powerSet(originalSet);
    }

    private Set<Set<V>> powerSet(Set<V> originalSet) {

        if(originalSet == null)
            return null;

        Set<Set<V>> sets = new HashSet<Set<V>>();
        if (originalSet.isEmpty()) {
            sets.add(new HashSet<V>());
            return sets;
        }

        List<V> list = new ArrayList<V>(originalSet);
        V head = list.get(0);
        Set<V> rest = new HashSet<V>(list.subList(1, list.size()));

        for (Set<V> set : powerSet(rest)) {
            Set<V> newSet = new HashSet<V>();
            newSet.add(head);
            newSet.addAll(set);
            sets.add(newSet);
            sets.add(set);
        }
        return sets;
    }

    public Set<Set<V>>  getPowerSet(){
        return this.powerSet;
    }

    public Set<Set<V>> getSubsetsOfSize(int size){
        Set<Set<V>> subsetSet = new HashSet<Set<V>>();

        for (Set<V> setOfV : this.powerSet) {
            if(setOfV.size() == size){
                subsetSet.add(setOfV);
            }
        }
        return subsetSet;
    }
}
