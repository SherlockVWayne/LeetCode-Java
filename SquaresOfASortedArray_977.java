package LeetCode;

public class SquaresOfASortedArray_977 {
    public int[] sortedSquares(int[] nums) {
        if (nums == null || nums.length == 0) return null;

        int positivePointer = 0;
        while (positivePointer < nums.length && nums[positivePointer] < 0) {
            positivePointer += 1;
        }
        int negativePointer = positivePointer - 1; // last neg num & first pos num

        int[] sortedSquares = new int[nums.length];
        int counter = 0;

        while (negativePointer >= 0 && positivePointer < nums.length) {
            if (Math.pow(nums[negativePointer], 2) < Math.pow(nums[positivePointer], 2)) {
                sortedSquares[counter++] = (int) Math.pow(nums[negativePointer--], 2);
            } else {
                sortedSquares[counter++] = (int) Math.pow(nums[positivePointer++], 2);
            }
        }
        while (negativePointer >= 0) {
            sortedSquares[counter++] = (int) Math.pow(nums[negativePointer--], 2);
        }
        while (positivePointer < nums.length) {
            sortedSquares[counter++] = (int) Math.pow(nums[positivePointer++], 2);
        }
        return sortedSquares;
    }

    /*
        Faster
     */
    public int[] sortedSquaresII(int[] nums) {
        if (nums == null || nums.length == 0) return null;

        int positivePointer = 0;
        while (positivePointer < nums.length && nums[positivePointer] < 0) {
            positivePointer += 1;
        }
        int negativePointer = positivePointer - 1; // last neg num & first pos num

        int[] sortedSquares = new int[nums.length];
        int counter = 0;

        while (negativePointer >= 0 && positivePointer < nums.length) {
            if (nums[negativePointer] * nums[negativePointer] < nums[positivePointer] * nums[positivePointer]) {
                sortedSquares[counter] = nums[negativePointer] * nums[negativePointer];
                negativePointer -= 1;
                counter += 1;
            } else {
                sortedSquares[counter] = nums[positivePointer] * nums[positivePointer];
                positivePointer += 1;
                counter += 1;
            }
        }
        while (negativePointer >= 0) {
            sortedSquares[counter] = nums[negativePointer] * nums[negativePointer];
            negativePointer -= 1;
            counter += 1;
        }
        while (positivePointer < nums.length) {
            sortedSquares[counter] = nums[positivePointer] * nums[positivePointer];
            positivePointer += 1;
            counter += 1;
        }
        return sortedSquares;
    }
}
