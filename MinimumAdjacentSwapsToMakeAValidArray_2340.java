package LeetCode;

public class MinimumAdjacentSwapsToMakeAValidArray_2340 {
    public int minimumSwaps(int[] nums) {
        int indexMax = 0, indexMin = 0;
        int min = nums[0], max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < min) {//get the first occurance
                min = nums[i];
                indexMin = i;
            }
            if (nums[i] >= max) {//get the last occurance
                max = nums[i];
                indexMax = i;
            }
        }
        boolean isOverlap = indexMax < indexMin;
        int swapsForMin = indexMin;
        int swapsForMax = nums.length - indexMax - 1;
        return isOverlap ? swapsForMin + swapsForMax - 1 : swapsForMin + swapsForMax;
    }
}
// Intuition and Approach
// 1.) Find the 1st index/occurance of the smallest element, find the last index/occurance of the largest element.
// 2.) If while moving the smallest to the left or moving the largset to the right, if there is going to be a swap between the smallest and the laegest, then remember to take the occurance of this event into account and subtract 1 from your total steps required to move smallest to the left and largest to the right.
//
// Complexity
// Time complexity: O(N)
// Space complexity: O(1)