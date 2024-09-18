package LeetCode;

public class LongestIncreasingPathInAMatrix_329 {
    private int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        
        int maxPathLength = 0;
        int[][] cache = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int currPathLength = dfs(matrix, i, j, 1, cache);
                maxPathLength = Math.max(maxPathLength, currPathLength);
            }
        }
        return maxPathLength;
    }
    
    private boolean isInRange(int[][] matrix, int i, int j) {
        return i >= 0 && i < matrix.length && j >= 0 && j < matrix[0].length;
    }
    
    private int dfs(int[][] matrix, int i, int j, int currPathLength, int[][] cache) {
        if (!isInRange(matrix, i, j)) {
            return currPathLength;
        }
        if (cache[i][j] != 0) {
            return cache[i][j];
        }
        int maxPathLength = currPathLength;
        for (int[] dir : dirs) {
            int newI = i + dir[0];
            int newJ = j + dir[1];
            int newPathLength = 0;
            if (isInRange(matrix, newI, newJ) && matrix[newI][newJ] > matrix[i][j]) {
                newPathLength = 1 + dfs(matrix, newI, newJ, currPathLength, cache);
            }
            maxPathLength = Math.max(newPathLength, maxPathLength);
        }
        cache[i][j] = maxPathLength;
        return maxPathLength;
    }
}
/**
 * Do DFS from every cell
 * 1. Compare every 4 direction and skip cells that are out of boundary or smaller
 * 2. Get matrix max from every cell's max
 * 3. Use matrix[x][y] <= matrix[i][j] so we don't need a visited[m][n] array
 * 4. The key is to cache the distance because it's highly possible to revisit a cell
 */