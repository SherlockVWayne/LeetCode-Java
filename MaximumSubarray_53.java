package LeetCode;

public class MaximumSubarray_53 {
    
    public int maxSubArray_II(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];//dp[i] means the maximum subarray ending with A[i];
        dp[0] = nums[0];
        int max = dp[0];
        
        for (int i = 1; i < n; i++) {
            dp[i] = nums[i] + (Math.max(dp[i - 1], 0));
            max = Math.max(max, dp[i]);
        }
        
        return max;
    }
    
    public int maxSubArray_III(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int globalMax = nums[0];
        int prevLocalMax = nums[0];           // max subarray ending with nums[i - 1]
        int currLocalMax = Integer.MIN_VALUE; // max subarray ending with nums[i]
        
        for (int i = 1; i < nums.length; i++) {
            currLocalMax = nums[i] + Math.max(prevLocalMax, 0);
            globalMax = Math.max(currLocalMax, globalMax);
            prevLocalMax = currLocalMax;
        }
        
        return globalMax;
    }
    
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        
        int max = subArray(nums, 0, nums.length - 1);
        
        return max;
    }
    
    public int subArray(int[] nums, int left, int right) {
        if (left == right) return nums[left];
        
        int middle = left + (right - left) / 2;
        
        int leftSum = subArray(nums, left, middle);
        int rightSum = subArray(nums, middle + 1, right);
        int middleSum = midSubArray(nums, left, middle, right);
        
        if (leftSum >= rightSum && leftSum >= middleSum) {
            return leftSum;
        } else if (rightSum >= leftSum && rightSum >= middleSum) {
            return rightSum;
        } else {
            return middleSum;
        }
    }
    
    public int midSubArray(int[] nums, int left, int middle, int right) {
        int sum = 0;
        int leftSum = Integer.MIN_VALUE;
        int rightSum = Integer.MIN_VALUE;
        
        for (int i = middle; i >= left; i--) {
            sum += nums[i];
            if (leftSum < sum) leftSum = sum;
        }
        
        sum = 0;
        
        for (int i = middle + 1; i <= right; i++) {
            sum += nums[i];
            if (rightSum < sum) rightSum = sum;
        }
        
        return leftSum + rightSum;
    }
    
    public static int maxSubArray_TEST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int globalMax = 0;
        int prevLocalMax = nums[0];
        int currLocalMax = 0;
        
        int[] dp = new int[nums.length];
        int max = 0;
        
        for (int i = 1; i < nums.length; i++) {
            currLocalMax = nums[i] + Math.max(prevLocalMax, 0);
            globalMax = Math.max(currLocalMax, globalMax);
            prevLocalMax = currLocalMax;
            System.out.println("prevLocalMax: " + prevLocalMax);
            System.out.println("currLocalMax: " + currLocalMax);
            System.out.println("globalMax: " + globalMax);
            System.out.println();
            
            dp[i] = nums[i] + (Math.max(dp[i - 1], 0));
            max = Math.max(max, dp[i]);
        }
        
        return globalMax;
    }
    
    public static void main(String[] args) {
    
    }
}
