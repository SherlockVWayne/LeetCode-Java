package LeetCode;

import java.util.LinkedList;

public class DailyTemperatures_739 {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        LinkedList<Integer> stack = new LinkedList<>();
        // store index
        // if currTemp <= stack.peek
        // stack.offerLast(currTemp_index);
        // else if currTemp > stack.peek
        // update result array, and pollLast
        stack.offerLast(0);
        
        for (int i = 1; i < temperatures.length; i++) {
            if (temperatures[i] <= temperatures[stack.peekLast()]) {
                stack.offerLast(i);
            } else {
                while (!stack.isEmpty() && temperatures[stack.peekLast()] < temperatures[i]) {
                    result[stack.peekLast()] = i - stack.peekLast();
                    stack.pollLast();
                }
                stack.offerLast(i);
            }
        }
        
        return result;
    }
}
