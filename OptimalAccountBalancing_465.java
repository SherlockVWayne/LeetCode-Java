package LeetCode;

import java.util.*;

public class OptimalAccountBalancing_465 {
    public int minTransfers(int[][] transactions) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        // get map for all accounts' balance value
        for (int[] transaction : transactions) {
            map.put(transaction[0], map.getOrDefault(transaction[0], 0) + transaction[2]);
            // for index[0]: it owns others, so balance +=
            map.put(transaction[1], map.getOrDefault(transaction[1], 0) - transaction[2]);
            // for index[1]: it should be paid by others, so balance -=
        }
        
        List<Integer> list = new ArrayList<>();
        for (int v : map.values()) {
            if (v != 0) {
                list.add(v);
            }
        }
        
        return dfs(0, list);
    }
    
    private int dfs(int index, List<Integer> list) {
        if (index == list.size()) {
            return 0;
        }
        
        int currentBalance = list.get(index);
        
        if (currentBalance == 0) {
            return dfs(index + 1, list);
        }
        
        int min = Integer.MAX_VALUE;
        
        for (int i = index + 1; i < list.size(); i++) {
            int nextBalance = list.get(i);
            if (currentBalance * nextBalance < 0) {
                list.set(i, currentBalance + nextBalance);
                min = Math.min(min, 1 + dfs(index + 1, list));
                list.set(i, nextBalance);
                
                // pruning
                if (currentBalance + nextBalance == 0) {
                    break;
                }
            }
        }
        return min;
    }
}
// start from first non-zero value, try to settle up with rest
// compare with all possible assignment and get global min
// e.g.:
// 0 should be paid 2
// 1 should be paid 2
// 2 should be paid -2 (2 owns others $2)
// 3 should be paid -3 (3 owns others $3)
// 4 should be paid 1
// for 0, 2 + (-2) = 0, optimal solution, so 0 get paid from 2 -> end early
// for 1, 2 * (-3) is global min, so 1 get paid from 3
