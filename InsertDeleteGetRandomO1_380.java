package LeetCode;

import java.util.ArrayList;
import java.util.*;

public class InsertDeleteGetRandomO1_380 {
    ArrayList<Integer> numsList; // store all input numbers
    HashMap<Integer, Integer> numsMap; // record key and its input order
    Random random = new Random();
    
    /**
     * Initialize your data structure here.
     */
    public InsertDeleteGetRandomO1_380() {
        numsList = new ArrayList<Integer>();
        numsMap = new HashMap<Integer, Integer>();
    }
    
    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (numsMap.containsKey(val)) {
            return false;
        }
        numsMap.put(val, numsList.size());
        numsList.add(val);
        return true;
    }
    
    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (!numsMap.containsKey(val)) {
            return false;
        }
        int order = numsMap.get(val);
        if (order < numsList.size() - 1) {
            // if not the last one, than swap the last one with this val
            int finalInputElement = numsList.get(numsList.size() - 1);
            numsList.set(order, finalInputElement);
            // update the missing index of order with finalInputElement
            // 1, 2, 5, 7, 6   remove: 5, finalInputElement: 6
            // 1, 2,[], 7, 6
            // 1, 2, 6, 7
            numsMap.put(finalInputElement, order);
        }
        numsMap.remove(val);
        numsList.remove(numsList.size() - 1);
        return true;
    }
    
    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        return numsList.get(random.nextInt(numsList.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */

// https://leetcode.com/problems/insert-delete-getrandom-o1/discuss/85401/Java-solution-using-a-HashMap-and-an-ArrayList-along-with-a-follow-up.-(131-ms)

// The follow-up: allowing duplications.
// For example, after insert(1), insert(1), insert(2), getRandom() should have 2/3 chance return 1 and 1/3 chance return 2.
// Then, remove(1), 1 and 2 should have an equal chance of being selected by getRandom().

// The idea is to add a set to the hashMap to remember all the locations of a duplicated number.
