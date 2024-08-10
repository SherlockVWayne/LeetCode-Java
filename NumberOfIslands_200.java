package LeetCode;

public class NumberOfIslands_200 {
    private final int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    result += 1;
                    bfs(grid, i, j);
                }
            }
        }
        return result;
    }
    
    private void bfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length ||
            grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        
        for (int[] dir : dirs) {
            bfs(grid, i + dir[0], j + dir[1]);
        }
    }
}
