package LeetCode;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class TrappingRainWater_II_407 {
    public static int trapRainWater(int[][] heightMap) {
        if (heightMap == null || heightMap.length == 0 || heightMap[0].length == 0) {
            return 0;
        }
        
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        
        int rows = heightMap.length;
        int cols = heightMap[0].length;
        int rain = 0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        boolean[][] visited = new boolean[rows][cols];
        
        for (int i = 0; i < rows; i++) {
            pq.offer(new int[]{i, 0, heightMap[i][0]});
            pq.offer(new int[]{i, cols - 1, heightMap[i][cols - 1]});
            visited[i][0] = true;
            visited[i][cols - 1] = true;
        }
        int temp = 0;
        for (int j = 1; j < cols - 1; j++) {
            pq.offer(new int[]{0, j, heightMap[0][j]});
            pq.offer(new int[]{rows - 1, j, heightMap[rows - 1][j]});
            visited[0][j] = true;
            visited[rows - 1][j] = true;
        }
        
        while (!pq.isEmpty()) {
            int[] cell = pq.poll();
            
            for (int[] dir : dirs) {
                int i = cell[0] + dir[0];
                int j = cell[1] + dir[1];
                if (i < 0 || i >= rows || j < 0 || j >= cols || visited[i][j]) continue;
                rain += Math.max(0, cell[2] - heightMap[i][j]);
                pq.offer(new int[]{i, j, Math.max(heightMap[i][j], cell[2])});
                visited[i][j] = true;
            }
        }
        
        return rain;
    }
    
    public static void main(String[] args) {
        int[][] heightMap = new int[][]{
            {1, 4, 3, 1, 3, 2}, {3, 2, 1, 3, 2, 4}, {2, 3, 3, 2, 3, 1}
        };
        
        System.out.println(trapRainWater(heightMap));
    }
}
