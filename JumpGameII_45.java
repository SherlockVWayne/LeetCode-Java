package LeetCode;

public class JumpGameII_45 {
    public int jump(int[] nums) {
        int count = 0;
        int currentEnd = 0;
        int currentFarthest = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            currentFarthest = Math.max(currentFarthest, nums[i] + i);

            if (i == currentEnd) {
                count++;
                currentEnd = currentFarthest;
            }
        }

        return count;
    }
}
