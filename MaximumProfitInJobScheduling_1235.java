package LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Job {
    int start;
    int end;
    int profit;
    
    public Job(int start, int end, int profit) {
        this.start = start;
        this.end = end;
        this.profit = profit;
    }
}

public class MaximumProfitInJobScheduling_1235 {
    
    public static void main(String[] args) {
        System.out.println(new MaximumProfitInJobScheduling_1235().jobScheduling(
            new int[]{1, 2, 3, 4, 6},
            new int[]{3, 5, 10, 6, 9},
            new int[]{20, 20, 100, 70, 60}
        ));
    }
    
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        List<Job> jobsList = new ArrayList<>();
        for (int i = 0; i < startTime.length; i++) {
            Job job = new Job(startTime[i], endTime[i], profit[i]);
            jobsList.add(job);
        }
        jobsList.sort((a, b) -> a.start - b.start);
        int currentProfit = 0;
        // max total profit can have from any combination of jobs
        // that FINISH STRICTLY BEFORE the next job’s start time
        int maxProfit = 0;
        PriorityQueue<Job> pq = new PriorityQueue<>(jobsList.size(), (a, b) -> a.end - b.end);
        for (Job job : jobsList) {
            while (!pq.isEmpty() && pq.peek().end <= job.start) {
                currentProfit = Math.max(currentProfit, pq.peek().profit);
                pq.poll();
            }
            // add the current job to heap
            job.profit += currentProfit;
            pq.offer(job);
        }
        while (!pq.isEmpty()) {
            maxProfit = Math.max(maxProfit, pq.peek().profit);
            pq.remove();
        }
        return maxProfit;
    }
}
// TC: O(nlogn) -> sort
// SC: O(n) -> worst case, pq is full

// jobsList:
// 1   3   20
// 2   5   20
// 3  10  100
// 4   6   70
// 6   9   60

// pq:
// 1   3   20
// 2   5   20

// pq:
// 1   3   20 <- 3  10  100
// 2   5   20

// pq:
// 2   5   20 <- 6   9   60
// 3  10  120
// 4   6   70

// pq:
// 6   9   80
// 4   6   70 < heap top <- 6   9   80
// 3  10  120

// pq:
// 6   9  150 < heap top
// 3  10  120