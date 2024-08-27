package LeetCode;

import java.util.ArrayList;
import java.util.Collections;
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
        List<Job> jobs = new ArrayList<>();
        for (int i = 0; i < startTime.length; i++) {
            Job job = new Job(startTime[i], endTime[i], profit[i]);
            jobs.add(job);
        }
        Collections.sort(jobs, (a, b) -> a.start - b.start);
        int currentProfit = 0;
        int maxProfit = 0;
        PriorityQueue<Job> pq = new PriorityQueue<>(jobs.size(), (a, b) -> a.end - b.end);
        for (Job job : jobs) {
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
