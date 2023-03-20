package LeetCode;

import java.util.Arrays;
import java.util.Scanner;

public class MinimumIncrementToMakeArrayUnique_945 {
    public static int minIncrementForUnique(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        Arrays.sort(nums);
        int result = 0;
        int need = 0;
        for (int num : nums) {
            result += Math.max(need - num, 0);
            /**
             * need - num > 0: current num < needed num, need to make moves
             *                 (e.g.: needed 5, current 3, need to move 2)
             * need - num < 0: current num > needed num (e.g.: needed 5, current 7)
             * need - num = 0: current num = needed num, no need to make moves
             */
            need = Math.max(num, need) + 1;
            // based on current num, next num needed should be >= need
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] str = scanner.nextLine().split(" ");
        int[] nums = new int[str.length];
        for (int i = 0; i < str.length; i++) {
            nums[i] = Integer.valueOf(str[i]);
        }
        System.out.println(minIncrementForUnique(nums));
    }
}

/**
 * Sort the input array.
 * Compared with previous number,
 * the current number need to be at least prev + 1.
 * <p>
 * Time Complexity: O(NlogN) for sorting
 * Space: O(1) for in-space sort
 * <p>
 * Note that you can apply "O(N)" sort in sacrifice of space.
 * Here we don't talk further about sort complexity.
 */
