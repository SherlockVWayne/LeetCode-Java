package LeetCode;

public class FindPeakElement_162 {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while(left < right) {
            if (left + 1 == right) {
                return nums[left] > nums[right] ? left : right;
            }
            int middle = left + (right - left) / 2;
            if (nums[middle] > nums[middle - 1] && nums[middle] > nums[middle + 1]) {
                return middle;
            } else if (nums[middle] > nums[middle - 1] && nums[middle] < nums[middle + 1]) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return left;
    }
}
