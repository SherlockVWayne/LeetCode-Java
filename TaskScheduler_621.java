package LeetCode;

import java.util.Arrays;

public class TaskScheduler_621 {
    public int leastInterval(char[] tasks, int n) {
        int[] charCounts = new int[26];
        for (char c : tasks) {
            charCounts[c - 'A']++;
        }
        Arrays.sort(charCounts);

        int maxVal = charCounts[25] - 1;
        int idleSlots = maxVal * n;
        for (int i = 24; i >= 0; i--) {
            idleSlots -= Math.min(charCounts[i], maxVal);
        }

        return idleSlots > 0 ? idleSlots + tasks.length : tasks.length;
    }
}
