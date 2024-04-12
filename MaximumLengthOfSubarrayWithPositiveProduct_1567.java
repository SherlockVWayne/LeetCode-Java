package LeetCode;

public class MaximumLengthOfSubarrayWithPositiveProduct_1567 {
    public int getMaxLen(int[] nums) {
        // sum is used to count the number of negative numbers from zeroPosition to current index
        int firstNegIndex = -1;
        int zeroIndex = -1;
        int numOfNegNums = 0;
        int maxPosProdLength = 0;
        
        for (int i = 0; i < nums.length; i++) {
            // Step I: only check first neg index
            if (nums[i] < 0) {
                numOfNegNums++;
                // we only need to know index of first negative number
                if (firstNegIndex == -1) {
                    firstNegIndex = i;
                }
            }
            
            if (nums[i] == 0) {
                // Step II.I: if nums[i] == 0
                // if current number is 0, we can't use any element from index 0 to i anymore
                // so update zeroIndex, and reset sum and firstNegative.
                // If it is a game, we should refresh the game when we meet 0.
                numOfNegNums = 0;
                firstNegIndex = -1;
                zeroIndex = i;
            } else {
                // Step II.II: if nums[i] != 0
                // consider index of zero
                if (numOfNegNums % 2 == 0) {
                    maxPosProdLength = Math.max(i - zeroIndex, maxPosProdLength);
                    // consider index of first negative number
                } else {
                    maxPosProdLength = Math.max(i - firstNegIndex, maxPosProdLength);
                }
            }
        }
        return maxPosProdLength;
    }
}
