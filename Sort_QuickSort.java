package LeetCode;

public class Sort_QuickSort {
    public int[] quickSort(int[] array) {
        if (array == null || array.length == 0) return array;
        quickSort(array, 0, array.length - 1);
        return array;
    }
    
    public void quickSort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        
        int pivotIndex = partition(array, left, right);
        
        quickSort(array, left, pivotIndex - 1);
        quickSort(array, pivotIndex + 1, right);
    }
    
    // return: pivot index, and array would be rearranged based on pivot
    public int partition(int[] array, int left, int right) {
        int pivotIndex = left + (int) (Math.random() * (right - left));
        int pivot = array[pivotIndex];
        
        swap(array, pivotIndex, right);
        
        int leftBound = left;
        int rightBound = right - 1;
        
        while (leftBound <= rightBound) {
            if (array[leftBound] < pivot) {
                leftBound++;
            } else if (array[rightBound] > pivot) {
                rightBound--;
            } else {
                swap(array, leftBound++, rightBound--);
            }
        }
        
        swap(array, leftBound, right);
        return leftBound;
    }
    
    public void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
