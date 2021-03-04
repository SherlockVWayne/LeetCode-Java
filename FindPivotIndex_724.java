package LeetCode;

public class FindPivotIndex_724 {
    public int pivotIndex(int[] nums) {
        int totalSum = 0;

        for (int i = 0; i < nums.length; i ++) {
            totalSum += nums[i];
        }

        int leftSum = 0;
        for (int i = 0; i < nums.length; i ++) {
            if (i != 0) leftSum += nums[i - 1];
            if (totalSum - leftSum - nums[i] == leftSum) return i;
        }

        return -1;
    }
}
