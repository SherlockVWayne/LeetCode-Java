package LeetCode;

import java.util.*;

public class SingleThreadedCPU_1834 {
  public static int[] getOrder(int[][] tasks) {
    if (tasks == null || tasks.length == 0 || tasks[0].length == 0) {
      return new int[]{};
    }
    
    int[] result = new int[tasks.length];
    
    int[][] indexedTasks = new int[tasks.length][3];
    for (int i = 0; i < tasks.length; i++) {
      indexedTasks[i][0] = i;
      indexedTasks[i][1] = tasks[i][0];
      indexedTasks[i][2] = tasks[i][1];
    }
    
    Arrays.sort(indexedTasks, (a, b) -> a[1] - b[1]);
    // sort tasks based on enqueueTime in ascending order
    
    PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> a[2] == b[2] ? a[0] - b[0] : a[2] - b[2]);
    
    int time = 0;
    int resultIndex = 0;
    int timeIndex = 0;
    
    while (resultIndex < tasks.length) {
      while (timeIndex < tasks.length && indexedTasks[timeIndex][1] <= time) {
        pq.offer(indexedTasks[timeIndex++]);
      }
      
      if (pq.isEmpty()) {
        time = indexedTasks[timeIndex][1];
        continue;
      }
      
      int[] bestTask = pq.poll();
      result[resultIndex++] = bestTask[0];
      time += bestTask[2];
    }
    
    return result;
  }
  
  public static void main(String[] args) {
    System.out.println(Arrays.toString(getOrder(new int[][]{{1, 2}, {2, 4}, {3, 2}, {4, 1}})));
    System.out.println(Arrays.toString(getOrder(new int[][]{{7, 10}, {7, 12}, {7, 5}, {7, 4}, {7, 2}})));
    
    
  }
}
