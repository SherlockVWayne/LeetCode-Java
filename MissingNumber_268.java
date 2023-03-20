package LeetCode;

import java.util.Arrays;

public class MissingNumber_268 {
    public static int missingNumber(int[] nums) {
        int min = nums[0];
        int xor = 0;
        for (int i : nums) {
            if (i < min) {
                min = i;
            }
        }
        
        for (int i = min; i < min + nums.length + 1; i++) {
            xor ^= i;
        }
        for (int i : nums) {
            xor ^= i;
        }
        return xor;
    }
    
    public static void main(String[] args) {
        System.out.println(missingNumber(new int[]{3, 5, 6, 4, 7, 1}));
    }
}
