package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CollatzConjecture {
    public static List<Integer> getCollatzSequence(int number) {
        List<Integer> sequence = new ArrayList<>();
        sequence.add(number);
        
        while (number != 1) {
            if (number % 2 == 0) {
                number = number / 2;
            } else {
                number = 3 * number + 1;
            }
            sequence.add(number);
        }
        
        return sequence;
    }
    
    public static List<Integer> getCollatzSequence_II(int number) {
        Map<Integer, List<Integer>> cache = new HashMap<>();
        if (cache.containsKey(number)) {
            return cache.get(number);
        }
        
        List<Integer> sequence = new ArrayList<>();
        sequence.add(number);
        
        while (number != 1) {
            if (number % 2 == 0) {
                number = number / 2;
            } else {
                number = 3 * number + 1;
            }
            sequence.add(number);
            
            // Memoization: store the sequence in the cache
            if (!cache.containsKey(number)) {
                cache.put(number, sequence.subList(sequence.indexOf(number), sequence.size()));
            }
        }
        
        return sequence;
    }
    
    
    public static void main(String[] args) {
        Print.printIntList(getCollatzSequence_II(27));
    }
}
