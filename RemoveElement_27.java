package LeetCode;

import java.util.Arrays;

public class RemoveElement_27 {
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) return 0;
        
        int validSize = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[validSize] = nums[i];
                validSize++;
            }
        }
        
        return validSize;
    }
    
    public int removeElement_II(int[] nums, int val) {
        if (nums.length == 0) return 0;
        
        int validSize = (int) Arrays.stream(nums).filter(num -> num != val).count();
        int[] result = Arrays.stream(nums).filter(num -> num != val).toArray();
        System.arraycopy(result, 0, nums, 0, validSize);
        return validSize;
    }
}
