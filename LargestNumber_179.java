package LeetCode;

import java.util.Arrays;

public class LargestNumber_179 {
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) return "0";
        String[] array = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            array[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(array, (a, b) -> (b + a).compareTo(a + b));
        if (array[0].charAt(0) == '0') return "0";
        StringBuilder result = new StringBuilder(nums.length);
        for (String a : array) {
            result.append(a);
        }
        return result.toString();
    }
}
