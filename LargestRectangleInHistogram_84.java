package LeetCode;

import java.util.LinkedList;
import java.util.Stack;

public class LargestRectangleInHistogram_84 {
    // Mono stack:
    // descending from stack_top to stack_bottom:
    // find first less than
    // -> ..., 4, 3, 2, 1]
    // mid: stack.peek()
    // left: stack.pop(), stack.peek() - already visited, should be in stack
    // right: current
    public int largestRectangleArea_II(int[] heights) {
        int maxArea = 0;
        LinkedList<Integer> stack = new LinkedList<>();
        stack.push(0);
        
        int[] newHeight = new int[heights.length + 2];
        System.arraycopy(heights, 0, newHeight, 1, heights.length);
        newHeight[heights.length + 1] = 0;
        newHeight[0] = 0;
        
        for (int i = 1; i < newHeight.length; i++) {
            while (newHeight[i] < newHeight[stack.peekLast()]) {
                int mid = stack.pollLast();
                int w = i - stack.peekLast() - 1;
                int h = newHeight[mid];
                maxArea = Math.max(maxArea, w * h);
            }
            stack.offerLast(i);
            
        }
        return maxArea;
    }
    
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
