package LeetCode;

import java.util.Arrays;

public class MeetingRooms_252 {
    
    public boolean canAttendMeetings(int[][] intervals) {
        // need to figure out if there is overlap
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int prev = 0;
        for (int i = 1; i < intervals.length; i++) {
            int prevEnd = intervals[prev][1];
            int currStart = intervals[i][0];
            if (prevEnd > currStart) {
                return false;
            }
            prev = i;
        }
        return true;
    }
}
