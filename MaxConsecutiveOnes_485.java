package LeetCode;

public class MaxConsecutiveOnes_485 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxOnes = 0;
        int currentOnes = 0;

        for (int i = 0; i < nums.length; i ++) {
            if (nums[i] == 1) {
                currentOnes += 1;
                maxOnes = Math.max(maxOnes, currentOnes);
            } else {
                currentOnes = 0;
            }
        }
        return maxOnes;
    }

    public int findMaxConsecutiveOnes_II(int[] nums) {
        int max = 0;
        int localMax = 0;
        for (int n : nums) {
            max = Math.max(max, localMax = n == 0 ? 0 : localMax + 1);
        }
        return max;
    }
}
