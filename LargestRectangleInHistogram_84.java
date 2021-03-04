package LeetCode;

import java.util.Stack;

public class LargestRectangleInHistogram_84 {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) return 0;

        int maxArea = 0;

        Stack<Integer> stack = new Stack();
        stack.push(-1);

        for (int i = 0; i < heights.length; i++) {
            int currentBar = heights[i];

            while (stack.peek() != -1 && currentBar <= heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int width = i - stack.peek() - 1;
                int area = height * width;
                maxArea = Math.max(maxArea, area);
            }
            stack.push(i);
        }

        while (stack.peek() != -1) {
            int height = heights[stack.pop()];
            int width = heights.length - stack.peek() - 1;
            int area = height * width;

            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }
}
