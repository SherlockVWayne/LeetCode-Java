package LeetCode;

import java.util.*;

public class Amazon_02282024 {
    public static int[][] shortestDistance(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0][0];
        }
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        int[][] distances = new int[m][n];
        Queue<int[]> queue = new LinkedList<>();
        
        // Initialize the distances
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 'G') {
                    queue.offer(new int[]{i, j});
                } else {
                    distances[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        // BFS
        while (!queue.isEmpty()) {
            int[] guard = queue.poll();
            int row = guard[0];
            int col = guard[1];
            
            for (int[] dir : dirs) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];
                
                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n &&
                    matrix[newRow][newCol] == 'O' && distances[newRow][newCol] == Integer.MAX_VALUE) {
                    distances[newRow][newCol] = distances[row][col] + 1;
                    queue.offer(new int[]{newRow, newCol});
                }
            }
        }
        
        // Update guards to 0
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 'G') {
                    distances[i][j] = 0;
                } else if (matrix[i][j] == 'W') {
                    distances[i][j] = -1;
                }
            }
        }
        
        return distances;
    }
// Time complexity: O(N^2)
// Space complexity: O(N)
    
    public static void main(String[] args) {
        char[][] grid = {
            {'O', 'O', 'O', 'O', 'G'},
            {'O', 'W', 'W', 'O', 'O'},
            {'O', 'O', 'O', 'W', 'O'},
            {'G', 'W', 'W', 'W', 'O'},
            {'O', 'O', 'O', 'O', 'G'}
        };
        
        int[][] result = shortestDistance(grid);
        
        // Printing the result
        for (int[] row : result) {
            for (int i = 0; i < row.length; i++) {
                System.out.print(row[i] + " ");
            }
            System.out.println();
        }
    }
}

//    Given an (M x N) matrix filled with Open spaces, Guards, and Walls, replace all open
//    spaces with their shortest distance from a guard,
//    without going through any walls. Also replace guards with 0, and walls with -1 in the output.
//    O ==> Open Space
//    G ==> Guard
//    W ==> Wall
//    Input:
//    O O O O G
//    O W W O O
//    O O O W O
//    G W W W O
//    O O O O G
//    Output:
//    3 3 2 1 0
//    2 -1 -1 2 1
//    1 2 3 -1 2
//    0 -1 -1 -1 1
//    1 2 2 1 0