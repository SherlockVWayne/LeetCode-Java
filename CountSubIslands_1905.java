package LeetCode;

public class CountSubIslands_1905 {
    private final int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        for (int i = 0; i < grid1.length; i++) {
            for (int j = 0; j < grid1[0].length; j++) {
                if (grid1[i][j] == 0 && grid2[i][j] == 1) {
                    eliminateIsland(grid2, i, j);
                }
            }
        }
        int subIslandCounts = 0;
        for (int i = 0; i < grid1.length; i++) {
            for (int j = 0; j < grid1[0].length; j++) {
                if (grid1[i][j] == 1 && grid2[i][j] == 1) {
                    coverIsland(grid2, i, j);
                    subIslandCounts++;
                }
            }
        }
        return subIslandCounts;
    }
    
    private void coverIsland(int[][] grid, int i, int j) {
        eliminateIsland(grid, i, j);
    }
    
    private void eliminateIsland(int[][] grid, int i, int j) {
        grid[i][j] = 0;
        for (var dir : dirs) {
            int newI = i + dir[0];
            int newJ = j + dir[1];
            if (isInRangeAndValid(grid, newI, newJ)) {
                eliminateIsland(grid, newI, newJ);
            }
        }
    }
    
    private boolean isInRangeAndValid(int[][] grid, int i, int j) {
        return i >= 0 && j >= 0 && i < grid.length && j < grid[0].length && grid[i][j] != 0;
    }
}
