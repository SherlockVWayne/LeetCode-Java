package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class FactorCombinations_254 {
  public List<List<Integer>> getFactors(int n) {
    List<List<Integer>> results = new ArrayList<List<Integer>>();
    helper(results, new ArrayList<Integer>(), n, 2);
    return results;
  }
  
  public void helper(List<List<Integer>> results, List<Integer> currentResult, int remaining, int currentFactor) {
    if (remaining <= 1 && currentResult.size() > 1) {
      results.add(new ArrayList<Integer>(currentResult));
      return;
    }
    
    for (
        int i = currentFactor;
        i <= remaining; i++) {
      if (remaining % i == 0) {
        currentResult.add(i);
        helper(results, currentResult, remaining / i, i);
        currentResult.remove(currentResult.size() - 1);
      }
    }
  }
}
