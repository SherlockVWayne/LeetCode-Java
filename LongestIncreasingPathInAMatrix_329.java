package LeetCode;

public class LongestIncreasingPathInAMatrix_329 {
    public static final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    
    public int longestIncreasingPath(int[][] matrix) {
        int maxLength = 0;
        int[][] cache = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int increasingLength = dfs(matrix, i, j, cache);
                maxLength = Math.max(maxLength, increasingLength);
            }
        }
        return maxLength;
    }
    
    private int dfs(int[][] matrix, int i, int j, int[][] cache) {
        if (cache[i][j] != 0) {
            return cache[i][j];
        }
        
        int maxLength = 1;
        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length
                || matrix[x][y] <= matrix[i][j]) {
                continue;
            }
            int length = 1 + dfs(matrix, x, y, cache);
            maxLength = Math.max(maxLength, length);
        }
        cache[i][j] = maxLength;
        return maxLength;
    }
}
/**
 * Do DFS from every cell
 * 1. Compare every 4 direction and skip cells that are out of boundary or smaller
 * 2. Get matrix max from every cell's max
 * 3. Use matrix[x][y] <= matrix[i][j] so we don't need a visited[m][n] array
 * 4. The key is to cache the distance because it's highly possible to revisit a cell
 */