package LeetCode;

import java.util.HashMap;

public class DegreeOfAnArray_697 {
    public int findShortestSubArray(int[] nums) {
        HashMap<Integer, Integer> numCounts = new HashMap();
        int degree = 0;

        HashMap<Integer, Integer> firstSeen = new HashMap();
        int minLength = 0;

        for (int i = 0; i < nums.length; i++) {
            firstSeen.putIfAbsent(nums[i], i);
            numCounts.put(nums[i], numCounts.getOrDefault(nums[i], 0) + 1);
            if (numCounts.get(nums[i]) > degree) {
                degree = numCounts.get(nums[i]);
                minLength = i - firstSeen.get(nums[i]) + 1;
            } else if (numCounts.get(nums[i]) == degree) {
                minLength = Math.min(minLength, i - firstSeen.get(nums[i]) + 1);
            }
        }

        return minLength;
    }
}
