package LeetCode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class FindMinimumTimeToReachLastRoom_II_3342 {
    public int minTimeToReach(int[][] moveTime) {
        int rows = moveTime.length;
        int cols = moveTime[0].length;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        int[][] time = new int[rows][cols];
        
        for (int[] row : time) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        
        minHeap.offer(new int[]{0, 0, 0}); // time, x, y
        time[0][0] = 0;
        
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int currStepCost = 1;
        while (!minHeap.isEmpty()) {
            int[] currentElement = minHeap.poll();
            int currTime = currentElement[0];
            int currRow = currentElement[1];
            int currCol = currentElement[2];
            
            if (currRow == rows - 1 && currCol == cols - 1) {
                return currTime;
            }
            
            for (int[] dir : directions) {
                int nextRow = currRow + dir[0];
                int nextCol = currCol + dir[1];
                
                if (nextRow >= 0 && nextRow < rows && nextCol >= 0 && nextCol < cols) {
                    int waitTime = Math.max(moveTime[nextRow][nextCol] - currTime, 0);
                    int newTime = currTime + currStepCost + waitTime;
                    currStepCost = currStepCost == 1 ? 2 : currStepCost;
                    if (newTime < time[nextRow][nextCol]) {
                        time[nextRow][nextCol] = newTime;
                        minHeap.offer(new int[]{newTime, nextRow, nextCol});
                    }
                }
            }
        }
        
        return -1; // unreachable
    }
}
