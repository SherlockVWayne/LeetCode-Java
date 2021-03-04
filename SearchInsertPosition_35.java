package LeetCode;

public class SearchInsertPosition_35 {
    public int searchInsert(int[] nums, int target) {
        int leftPointer = 0;
        int rightPointer = nums.length - 1;

        while (leftPointer + 1 < rightPointer) {
            int middlePointer = leftPointer + (rightPointer - leftPointer) / 2;
            if (nums[middlePointer] == target) {
                return middlePointer;
            } else if (nums[middlePointer] < target) {
                leftPointer = middlePointer;
            } else {
                rightPointer = middlePointer;
            }
        }

        if (nums[rightPointer] < target) {
            return rightPointer + 1;
        } else if (nums[leftPointer] >= target) {
            return leftPointer;
        } else {
            return rightPointer;
        }
    }
}
