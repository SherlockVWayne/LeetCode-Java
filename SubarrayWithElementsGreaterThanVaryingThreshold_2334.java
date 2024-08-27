package LeetCode;

import java.util.Arrays;
import java.util.Stack;

public class SubarrayWithElementsGreaterThanVaryingThreshold_2334 {
    public static void main(String[] args) {
        System.out.println(validSubarraySize(new int[]{1, 3, 4, 3, 1}, 6));
    }
    
    //Create two arrays for next smaller and previous smaller for every elements of nums
    //Use next smaller element stack approach to fill the arrays.
    //Find the length of every element of nums from its previous smaller to next smaller.
    //divide the threshold by length and if it is greater than quotient return length else -1.
    //            1 3 4 3  1
    // prevSmall -1 0 1 0 -1
    // nextSmall  5 4 3 4  5
    public static int validSubarraySize(int[] nums, int threshold) {
        int n = nums.length;
        int[] nextSmall = new int[n];
        int[] prevSmall = new int[n];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        Arrays.fill(nextSmall, n);
        Arrays.fill(prevSmall, -1);
        for (int i = 1; i < n; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] >= nums[i]) {
                stack.pop();
            }
            if (stack.size() != 0) {
                prevSmall[i] = stack.peek();
            }
            stack.push(i);
        }
        stack = new Stack<>();
        stack.push(n - 1);
        for (int i = n - 2; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] >= nums[i]) {
                stack.pop();
            }
            if (stack.size() != 0) {
                nextSmall[i] = stack.peek();
            }
            stack.push(i);
        }
        for (int i = 0; i < n; i++) {
            int len = nextSmall[i] - prevSmall[i] - 1;
            if (threshold / (double) len < nums[i]) {
                return len;
            }
        }
        return -1;
    }
    
}
