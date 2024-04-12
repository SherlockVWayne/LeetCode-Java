package LeetCode;

public class MaximumProductSubarray_152 {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int currentMax = nums[0];
        int currentMin = nums[0];
        int globalMax = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            int temp = currentMax;
            currentMax = Math.max(Math.max(currentMax * nums[i], currentMin * nums[i]), nums[i]);
            currentMin = Math.min(Math.min(temp * nums[i], currentMin * nums[i]), nums[i]);
            
            globalMax = Math.max(currentMax, globalMax);
        }
        
        return globalMax;
    }
}
