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
}
