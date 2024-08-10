package LeetCode;

import java.util.*;

public class HighFive_1086 {
    public int[][] highFive(int[][] items) {
        if (items == null || items.length == 0) {
            return new int[][]{};
        }
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        for (int[] item : items) {
            int studentId = item[0];
            int score = item[1];
            map.putIfAbsent(studentId, new ArrayList<Integer>());
            map.get(studentId).add(score);
        }
        
        int[][] result = new int[map.keySet().size()][2];
        int resultIndex = 0;
        
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            result[resultIndex][0] = entry.getKey();
            result[resultIndex][1] = (int) entry.getValue().stream()
                .sorted(Comparator.reverseOrder()).limit(5)
                .mapToInt(Integer::intValue).average().orElse(0);
            resultIndex += 1;
        }
        
        return result;
    }
}
