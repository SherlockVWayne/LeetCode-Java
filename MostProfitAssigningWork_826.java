package LeetCode;

import java.util.TreeMap;

public class MostProfitAssigningWork_826 {
    public static void main(String[] args) {
//        System.out.println(new MostProfitAssigningWork_826().maxProfitAssignment(
//            new int[]{2, 4, 6, 8, 10},
//            new int[]{10, 20, 30, 40, 50},
//            new int[]{4, 5, 6, 7}
//        ));
        
        System.out.println(new MostProfitAssigningWork_826().maxProfitAssignment(
            new int[]{68, 35, 52, 47, 86},
            new int[]{67, 17, 1, 81, 3},
            new int[]{92, 10, 85, 84, 82}
        ));
    }
    
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        // key: difficulty, ascending
        // val: profit
        map.put(0, 0);
        
        for (int i = 0; i < difficulty.length; i++) {
            map.put(difficulty[i], Math.max(profit[i], map.getOrDefault(difficulty[i], 0)));
        }
        int bestProfitForDifficulty = 0;
        int result = 0;
        for (Integer key : map.keySet()) {
            bestProfitForDifficulty = Math.max(map.get(key), bestProfitForDifficulty);
            map.put(key, bestProfitForDifficulty);
        }
        // 0 ->  0
        // 35 ->  17
        // 47 ->  81
        // 52 ->  1
        // 68 ->  67
        // 86 ->  3
        
        // 0 ->  0
        // 35 ->  17
        // 47 ->  81
        // 52 ->  81
        // 68 ->  81
        // 86 ->  81
        for (int j : worker) {
            result += map.floorEntry(j).getValue();
        }
        return result;
    }
}
