package LeetCode;

import java.util.*;

public class UniqueNumberOfOccurrences_1207 {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> numOccurences = new HashMap();
        for (int num : arr) {
            numOccurences.put(num, numOccurences.getOrDefault(num, 0) + 1);
        }
        HashSet<Integer> uniqueVals = new HashSet<Integer>(numOccurences.values());
        return numOccurences.size() == uniqueVals.size();
    }
}
