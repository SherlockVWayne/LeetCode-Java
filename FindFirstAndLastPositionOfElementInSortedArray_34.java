package LeetCode;

public class FindFirstAndLastPositionOfElementInSortedArray_34 {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0)  return new int[] {-1, -1};

        int[] result = new int[2];
        int index = -1;
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int middle = start + (end - start) / 2;
            if (nums[middle] >= target) {
                end = middle - 1;
            } else {
                start = middle + 1;
            }
            if (nums[middle] == target) index = middle;
        }

        result[0] = index;

        index = -1;
        start = 0;
        end = nums.length - 1;
        while (start <= end) {
            int middle = start + (end - start) / 2;
            if (nums[middle] <= target) {
                start = middle + 1;
            } else {
                end = middle - 1;
            }
            if (nums[middle] == target) index = middle;
        }
        result[1] = index;

        return result;
    }
}
