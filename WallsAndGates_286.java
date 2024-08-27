package LeetCode;

import java.util.LinkedList;

public class WallsAndGates_286 {
    private int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    
    public void wallsAndGates(int[][] rooms) {
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    dfs(rooms, i, j, 0);
                }
            }
        }
    }
    
    private void dfs(int[][] rooms, int i, int j, int depth) {
        if (i < 0 || i >= rooms.length || j < 0 || j >= rooms[0].length
            || rooms[i][j] < depth) {
            return;
        }
        rooms[i][j] = depth;
        if (i < rooms.length - 1 && depth + 1 < rooms[i + 1][j]) {
            dfs(rooms, i + 1, j, depth + 1);
        }
        if (i > 0 && depth + 1 < rooms[i - 1][j]) {
            dfs(rooms, i - 1, j, depth + 1);
        }
        if (j < rooms[i].length - 1 && depth + 1 < rooms[i][j + 1]) {
            dfs(rooms, i, j + 1, depth + 1);
        }
        if (j > 0 && depth + 1 < rooms[i][j - 1]) {
            dfs(rooms, i, j - 1, depth + 1);
        }
    }
    
    public void wallsAndGates_II(int[][] rooms) {
        if (rooms.length == 0 || rooms[0].length == 0) {
            return;
        }
        LinkedList<int[]> queue = new LinkedList<>();
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    queue.offerLast(new int[]{i, j});
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] top = queue.pollFirst();
            int row = top[0], col = top[1];
            if (row > 0 && rooms[row - 1][col] == Integer.MAX_VALUE) {
                rooms[row - 1][col] = rooms[row][col] + 1;
                queue.offerLast(new int[]{row - 1, col});
            }
            if (row < rooms.length - 1 && rooms[row + 1][col] == Integer.MAX_VALUE) {
                rooms[row + 1][col] = rooms[row][col] + 1;
                queue.offerLast(new int[]{row + 1, col});
            }
            if (col > 0 && rooms[row][col - 1] == Integer.MAX_VALUE) {
                rooms[row][col - 1] = rooms[row][col] + 1;
                queue.offerLast(new int[]{row, col - 1});
            }
            if (col < rooms[0].length - 1 && rooms[row][col + 1] == Integer.MAX_VALUE) {
                rooms[row][col + 1] = rooms[row][col] + 1;
                queue.offerLast(new int[]{row, col + 1});
            }
        }
    }
}
