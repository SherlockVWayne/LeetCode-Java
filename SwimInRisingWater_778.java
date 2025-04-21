package LeetCode;

import java.util.PriorityQueue;

public class SwimInRisingWater_778 {
    private int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    
    public static void main(String[] args) {
        System.out.println(new SwimInRisingWater_778().swimInWater(new int[][]{
            {0, 1, 2, 3, 4},
            {24, 23, 22, 21, 5},
            {12, 13, 14, 15, 16},
            {11, 17, 18, 19, 20},
            {10, 9, 8, 7, 6}
        }));
    }
    
    public int swimInWater(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        // Min Heap to pop out node with Least Maximum value in the respective path.
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[2] - b[2]));
        pq.offer(new int[]{0, 0, grid[0][0]});
        grid[0][0] = -1; // visited
        
        while (!pq.isEmpty()) {
            int[] currElement = pq.poll();
            int currRow = currElement[0];
            int currCol = currElement[1];
            int currMax = currElement[2];
            
            for (int[] dir : dirs) {
                int nextRow = currRow + dir[0];
                int nextCol = currCol + dir[1];
                
                if (nextRow < 0 || nextRow >= grid.length || nextCol < 0 || nextCol >= grid[0].length
                    || grid[nextRow][nextCol] == -1) {
                    continue;
                }
                int nextVal = grid[nextRow][nextCol];
                int nextMax = Math.max(nextVal, currMax);
                
                grid[nextRow][nextCol] = -1;  // visited
                
                if (nextRow == grid.length - 1 && nextCol == grid[0].length - 1) {
                    return nextMax;
                }
                
                pq.offer(new int[]{nextRow, nextCol, nextMax});
            }
        }
        
        return 0;
    }
}
