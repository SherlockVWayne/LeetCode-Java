package LeetCode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRooms_II_253 {
    public static void main(String[] args) {
        System.out.println(new MeetingRooms_II_253().minMeetingRooms(new int[][]{
            {0, 30}, {5, 10}, {15, 20}
        }));
    }
    
    public int minMeetingRooms(int[][] intervals) {
        //sort the array based upon start time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        
        //add to priority queue based on the ending time
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> a[1] - b[1]);
        pq.addAll(Arrays.asList(intervals));
        
        for (int i = 1; i < intervals.length; i++) {
            if (pq.peek()[1] <= intervals[i][0]) {
                pq.poll();
            }
        }
        return pq.size();
    }
}
