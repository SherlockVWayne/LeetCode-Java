package LeetCode;

public class RottingOranges_994 {
    private final int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0) return -1;
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    rotAdjacentBFS(grid, i, j, 2);
                }
            }
        }
        
        int minutes = 2;
        for (int[] row : grid) {
            for (int cell : row) {
                if (cell == 1) return -1;
                minutes = Math.max(minutes, cell);
            }
        }
        
        return minutes - 2;
    }
    
    private void rotAdjacentBFS(int[][] grid, int i, int j, int minutes) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length
            || grid[i][j] == 0 // empty cell
            || (1 < grid[i][j] && grid[i][j] < minutes) // already rotten by another rotten orange
        ) {
            return;
        } else {
            grid[i][j] = minutes;
            for (int[] dir : dirs) {
                rotAdjacentBFS(grid, i + dir[0], j + dir[1], minutes + 1);
            }
        }
    }
}