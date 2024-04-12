package LeetCode;

public class MaxAreaOfIsland_695 {
    
    private int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    
    public int maxAreaOfIsland_II(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    int area = bfsGetIslandArea(grid, i, j);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }
    
    private int bfsGetIslandArea(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length ||
            grid[i][j] == 0) {
            return 0;
        }
        grid[i][j] = 0;
        return 1 +
            bfsGetIslandArea(grid, i + 1, j) +
            bfsGetIslandArea(grid, i - 1, j) +
            bfsGetIslandArea(grid, i, j + 1) +
            bfsGetIslandArea(grid, i, j - 1);
    }
    
    
    boolean[][] visited;
    
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        
        int rows = grid.length;
        int columns = grid[0].length;
        
        visited = new boolean[rows][columns];
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                maxArea = Math.max(maxArea, getArea(i, j, grid));
            }
        }
        
        return maxArea;
    }
    
    public int getArea(int i, int j, int[][] grid) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0 || visited[i][j]) {
            return 0;
        }
        visited[i][j] = true;
        return (1 + getArea(i + 1, j, grid) + getArea(i - 1, j, grid) + getArea(i, j - 1, grid) + getArea(i, j + 1, grid));
    }
}
