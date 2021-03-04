package LeetCode;

public class MaxAreaOfIsland_695 {
    boolean[][] visited;
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;

        int rows = grid.length;
        int columns = grid[0].length;

        visited = new boolean[rows][columns];

        for (int i = 0; i < rows; i ++) {
            for (int j = 0; j < columns; j ++) {
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
