package LeetCode;

public class FindMinimumInRotatedSortedArray_153 {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int left = 0;
        int right = nums.length - 1;
        
        while (left < right) {
            int middle = left + (right - left) / 2;
            if (middle > 0 && nums[middle - 1] > nums[middle]) {
                return nums[middle];
            }
            if (nums[left] <= nums[middle] && nums[middle] > nums[right]) {
                // 4  5  6  7  0  1   2
                // l        m <-----> r
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        
        return nums[left];
    }
}
