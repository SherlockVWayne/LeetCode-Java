package LeetCode;

public class SearchInRotatedSortedArray_33 {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (nums[middle] == target) {
                return middle;
            } else if (nums[left] > nums[middle]) {
                // 6   7   0   1   2   3    4
                // l     >     m
                if (target < nums[middle] || nums[left] <= target) {
                    right = middle - 1;
                } else {
                    left = middle + 1;
                }
            } else if (nums[left] <= nums[middle]) {
                // 2   3   4   5   6   7   0   1
                // l     <=    m
                if (target < nums[left] || nums[middle] < target) {
                    left = middle + 1;
                } else {
                    right = middle - 1;
                }
            }
        }
        return -1;
    }
}
