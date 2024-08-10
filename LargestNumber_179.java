package LeetCode;

import java.util.*;

public class LargestNumber_179 {
    public static String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "0";
        }
        
        String[] array = new String[nums.length];
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < nums.length; i++) {
            array[i] = String.valueOf(nums[i]);
        }
        
        Arrays.sort(array, (a, b) -> (b + a).compareTo(a + b));
        
        if (array[0].charAt(0) == '0') {
            return "0";
        }
        
        for (String a : array) {
            sb.append(a);
        }
        
        return sb.toString();
    }
    
    public static void main(String[] args) {
        System.out.println(largestNumber(new int[]{3, 30, 34, 5, 9}));
    }
}
