package LeetCode;

import java.util.*;

public class NumberOfDistinctIslands_694 {
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
