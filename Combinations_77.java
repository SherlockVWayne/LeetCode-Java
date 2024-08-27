package LeetCode;

import java.util.*;

public class Combinations_77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        helper(result, new ArrayList<Integer>(), 1, n, k);
        return result;
    }
    
    public void helper(List<List<Integer>> result, List<Integer> list, int start, int n, int k) {
        if (k == 0) {
            result.add(new ArrayList<Integer>(list));
            return;
        }
        
        for (int i = start; i <= n; i++) {
            list.add(i);
            helper(result, list, i + 1, n, k - 1);
            list.remove(list.size() - 1);
        }
    }
    
    public List<List<Integer>> combine_II(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentCombination = new ArrayList<>();
        int startIndex = 1;
        int digitsLeft = k;
        backtracking(result, currentCombination, startIndex, digitsLeft, n);
        return result;
    }
    
    private void backtracking(List<List<Integer>> result, List<Integer> currentCombination, int startIndex, int digitsLeft, int n) {
        if (digitsLeft == 0) {
            result.add(new ArrayList<Integer>(currentCombination));
            return;
        }
        
        for (int i = startIndex; i <= n; i++) {
            currentCombination.add(i);
            backtracking(result, currentCombination, i + 1, digitsLeft - 1, n);
            currentCombination.remove(currentCombination.size() - 1);
        }
    }
}

// Backtracking principle:
// 1. input, output of backtracking/recursion function
// 2. termination condition
// 3. single level logic
