package LeetCode;

import java.util.PriorityQueue;

public class MinTimeToDestination {
    
    private static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    
    public static void main(String[] args) {
        int[][] input = new int[][]{
            {0, 1, 2, 3, 4},
            {24, 16, 22, 21, 5},
            {12, 13, 14, 15, 23},
            {30, 17, 18, 19, 20},
            {10, 9, 8, 7, 6}};
        int[][] inputResult = new int[input.length][input[0].length];
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[i].length; j++) {
                inputResult[i][j] = Math.max(input[i][j] - 17, 0);
            }
        }
        Print.printInt2DArray(inputResult);
        System.out.println(new MinTimeToDestination().minTimeToDestination(input));
    }
    
    public int minTimeToDestination(int[][] grid) {
        // Priority queue to explore cells, sorting by time (minimum time first)
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
        
        // Start from the top-left corner
        pq.offer(new int[]{0, 0, grid[0][0]});
        
        // Visited array to prevent re-processing of cells
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        visited[0][0] = true;
        
        // Perform Dijkstra-like search
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int row = current[0];
            int col = current[1];
            int time = current[2];
            
            // If we've reached the bottom-right corner, return the time
            if (row == grid.length - 1 && col == grid[0].length - 1) {
                return time;
            }
            
            // Explore adjacent cells (up, down, left, right)
            for (int[] direction : dirs) {
                int newRow = row + direction[0];
                int newCol = col + direction[1];
                
                // Check if the new position is within bounds
                if (newRow >= 0 && newRow < grid.length - 1 &&
                    newCol >= 0 && newCol < grid[0].length - 1 &&
                    !visited[newRow][newCol]) {
                    // Calculate the time when the new cell becomes accessible
                    int newTime = Math.max(time, grid[newRow][newCol]);
                    
                    // Add the new cell to the priority queue
                    pq.offer(new int[]{newRow, newCol, newTime});
                    visited[newRow][newCol] = true;
                }
            }
        }
        // If no path found, return -1
        return -1;
    }
}
