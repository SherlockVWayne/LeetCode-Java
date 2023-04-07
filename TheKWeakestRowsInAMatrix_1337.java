package LeetCode;

import java.util.*;

import static javafx.scene.input.KeyCode.K;

public class TheKWeakestRowsInAMatrix_1337 {
    public static int[] kWeakestRows(int[][] mat, int k) {
        if (mat == null || mat.length == 0 || mat[0].length == 0) {
            return new int[]{};
        }
        int[] result = new int[k];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < mat.length; i++) {
            int soldiers = Arrays.stream(mat[i]).sum();
            map.put(i, soldiers);
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getValue() - o2.getValue();
            }
        });
        return list.stream().limit(k).mapToInt(Map.Entry::getKey).toArray();
    }
    
    public static void main(String[] args) {
        int[][] mat = new int[][]{{1, 1, 0, 0, 0}, {1, 1, 1, 1, 0}, {1, 0, 0, 0, 0}, {1, 1, 0, 0, 0}, {1, 1, 1, 1, 1}};
        int k = 3;
        Print.printIntArray(kWeakestRows(mat, k));
    }
}