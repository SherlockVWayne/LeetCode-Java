package LeetCode;

import java.util.Stack;

public class NumberOfVisiblePeopleInAQueue_1944 {
    // decreasing mono stack
    public int[] canSeePersonsCount(int[] heights) {
        if (heights == null || heights.length == 0) {
            return new int[]{};
        }
        int[] result = new int[heights.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] <= heights[i]) {
                result[stack.pop()] += 1;
            }
            if (!stack.isEmpty()) {
                result[stack.peek()] += 1;
            }
            stack.push(i);
        }
        return result;
    }
}
