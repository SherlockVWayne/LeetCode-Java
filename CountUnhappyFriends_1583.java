package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class CountUnhappyFriends_1583 {
    public static int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        int[] map = new int[n];
        for (int[] pair : pairs) { // Keep record of current matches.
            map[pair[0]] = pair[1];
            map[pair[1]] = pair[0];
        }
        int result = 0;
        
        HashMap<Integer, Integer>[] prefer = new HashMap[n]; // O(1) to fetch the index from the preference array.
        // key:
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (prefer[i] == null) {
                    prefer[i] = new HashMap<>();
                }
                prefer[i].put(preferences[i][j], j);
            }
        }
        
        for (int i = 0; i < n; i++) {
            for (int j : preferences[i]) {
                if (prefer[j].get(i) < prefer[j].get(map[j])
                    && prefer[i].get(map[i]) > prefer[i].get(j)) { // Based on the definition of "unhappy"
                    result++;
                    break;
                }
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
        System.out.println(unhappyFriends(4, new int[][]{{1, 2, 3}, {3, 2, 0}, {3, 1, 0}, {1, 2, 0}}, new int[][]{{0, 1}, {2, 3}}));
    }
}
