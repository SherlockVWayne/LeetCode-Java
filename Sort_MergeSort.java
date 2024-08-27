package LeetCode;

public class Sort_MergeSort {
    public int[] mergeSort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }
        return mergeSort(nums, 0, nums.length - 1);
    }
    
    private int[] mergeSort(int[] array, int left, int right) {
        // [left, right] is the range needs to be sorted
        if (left == right) {
            return new int[]{array[left]};
        }
        int middle = left + (right - left) / 2;
        int[] leftArray = mergeSort(array, left, middle);
        int[] rightArray = mergeSort(array, middle + 1, right);
        return merge(leftArray, rightArray);
    }
    
    private int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        
        int i = 0;
        int j = 0;
        int resultIndex = 0;
        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                result[i] = left[i];
                i++;
            } else {
                result[j] = right[j];
                j++;
            }
            resultIndex++;
        }
        while (i < left.length) {
            result[resultIndex++] = left[i++];
        }
        while (j < right.length) {
            result[resultIndex++] = right[j++];
        }
        return result;
    }
}
