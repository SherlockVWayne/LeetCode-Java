package LeetCode;

public class Sort_RainbowSort {
    private static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
    
    public int[] rainbowSort(int[] array) {
        // Write your solution here
        if (array == null || array.length == 0) return array;
        int negIndex = 0;
        int oneIndex = array.length - 1;
        int zeroIndex = 0;
        while (zeroIndex <= oneIndex) {
            if (array[zeroIndex] == -1) {
                swap(array, negIndex, zeroIndex);
                negIndex++;
                zeroIndex++;
            } else if (array[zeroIndex] == 0) {
                zeroIndex++;
            } else if (array[zeroIndex] == 1) {
                swap(array, zeroIndex, oneIndex);
                oneIndex--;
            }
        }
        return array;
    }
}
