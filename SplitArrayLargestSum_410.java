package LeetCode;

import java.util.Arrays;

public class SplitArrayLargestSum_410 {
    
    // O(n*log(sum))
    // guess the LargestSum, from max_element to total_sum
    public int splitArray(int[] nums, int k) {
        int totalSum = Arrays.stream(nums).sum();
        int maxElement = Arrays.stream(nums).max().getAsInt();
        return binarySearch(nums, k, maxElement, totalSum);
    }
    
    private int binarySearch(int[] nums, int k, int low, int high) {
        int middle = 0;
        while (low <= high) {
            middle = low + (high - low) / 2;
            if (valid(nums, k, middle)) {
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }
        return low;
    }
    
    private boolean valid(int[] nums, int m, int subArraySum) {
        int curSum = 0;
        int count = 1;
        for (int num : nums) {
            curSum += num;
            if (curSum > subArraySum) {
                curSum = num;
                count++;
                if (count > m) {
                    return false;
                }
            }
        }
        return true;
    }
}
