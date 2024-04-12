package LeetCode;

import java.util.*;

public class NumberOfDistinctIslands_694 {
    // private int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private Map<String, int[]> dirs = new HashMap<>() {{
        put("D", new int[]{0, 1});
        put("U", new int[]{0, -1});
        put("L", new int[]{-1, 0});
        put("R", new int[]{1, 0});
    }};
    
    public int numDistinctIslands_II(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        Set<String> uniqueIslands = new HashSet<String>();
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    StringBuilder island = new StringBuilder();
                    dfs(grid, i, j, island, "O"); // mark the origin
                    uniqueIslands.add(island.toString());
                }
            }
        }
        
        return uniqueIslands.size();
    }
    
    private void dfs(int[][] grid, int i, int j, StringBuilder island, String islandPath) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length ||
            grid[i][j] == 0
        ) {
            return;
        }
        island.append(islandPath);
        grid[i][j] = 0;
        for (Map.Entry<String, int[]> dir : dirs.entrySet()) {
            int[] direction = dir.getValue();
            dfs(grid, i + direction[0], j + direction[1], island, dir.getKey());
        }
        island.append("b"); // backtracking
    }
    
    /**
     * WARNING: DO NOT FORGET to add path for backtracking, otherwise, we may have same result when we count two
     * distinct islands in some cases
     * eg:              1 1 1   and    1 1 0
     * 0 1 0          0 1 1
     * with b:          rdbr           rdr
     * without b:       rdr            rdr
     */
    
    private static int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private static int cols;
    private static int rows;
    
    public static int numDistinctIslands(int[][] grid) {
        cols = grid[0].length;
        rows = grid.length;
        Set<String> uniqueShapes = new HashSet<>(); // Unique shpes.
        StringBuilder shape;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 0;
                    shape = new StringBuilder("o");
                    dfsTraversal(i, j, grid, shape);
                    uniqueShapes.add(shape.toString());
                    System.out.println(shape);
                }
            }
        }
        
        return uniqueShapes.size();
    }
    
    private static void dfsTraversal(int x, int y, int[][] grid, StringBuilder shape) {
        for (int i = 0; i < directions.length; i++) {
            int nextX = x + directions[i][0];
            int nextY = y + directions[i][1];
            if (nextX >= 0 && nextY >= 0 && nextX < rows && nextY < cols) {
                if (grid[nextX][nextY] == 1) {
                    grid[nextX][nextY] = 0;
                    shape.append(i);
                    dfsTraversal(nextX, nextY, grid, shape);
                }
            }
        }
        shape.append("_ ");
        // backtrack this move, total num of '_' represents how many '1's compose this shape
    }
    
    public static void main(String[] args) {
        int[][] grid = new int[][]{
            {1, 1, 1},
            {1, 0, 0},
            {0, 0, 1},
            {1, 1, 1},
            {0, 1, 0},
            {1, 1, 0}};
        int result = numDistinctIslands(grid);
        System.out.println(result);
        
        LinkedList<Integer> queue = new LinkedList<>();
    }
}
