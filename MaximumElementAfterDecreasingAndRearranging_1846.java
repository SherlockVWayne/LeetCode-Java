package LeetCode;

import java.util.Arrays;

public class MaximumElementAfterDecreasingAndRearranging_1846 {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        Arrays.sort(arr);
        int result = 0;
        for (int num : arr) {
            result = Math.min(num, result + 1);
        }
        return result;
    }
}

//Keep a variable of previous value pre.
//The current value should be no more than pre + 1.
//So we update pre = min(pre + 1).
//
//Finally pre equals the last element,
//which is also the biggest element.
//
//
//Complexity
//Time O(sort)
//Space O(sort)
