package LeetCode;

import java.util.*;

public class MergeIntervals_56 {
    public static int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return intervals;
        }

        Arrays.sort(intervals, (arr1, arr2) -> Integer.compare(arr1[0], arr2[0]));

        for (int[] interval : intervals) {
            System.out.println(interval[0] + " " + interval[1]);
        }

        List<int[]> output = new ArrayList();

        int[] currentInterval = intervals[0];
        output.add(currentInterval);

        for (int[] interval : intervals) {
            int currentBegin = currentInterval[0];
            int currentEnd = currentInterval[1];
            int nextBegin = interval[0];
            int nextEnd = interval[1];

            if (currentEnd >= nextBegin) {
                currentInterval[1] = Math.max(currentEnd, nextEnd);
            } else {
                currentInterval = interval;
                output.add(currentInterval);
            }
        }

        return output.toArray(new int[output.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] result = merge(intervals);

        System.out.println("Result: ");
        for (int[] interval : result) {
            System.out.println(interval[0] + " " + interval[1]);
        }
    }
}
