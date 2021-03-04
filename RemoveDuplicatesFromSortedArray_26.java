package LeetCode;

public class RemoveDuplicatesFromSortedArray_26 {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int leftPointer = 0;
        for (int rightPointer = 0; rightPointer < nums.length; rightPointer++) {
            if (nums[leftPointer] != nums[rightPointer]) {
                nums[++leftPointer] = nums[rightPointer];
            }
        }
        return leftPointer + 1;
    }
}
