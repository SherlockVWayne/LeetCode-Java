package LeetCode;

public class SearchA2DMatrix_74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int columns = matrix[0].length;

        int leftIndex = 0;
        int rightIndex = rows * columns - 1;

        while (leftIndex <= rightIndex) {
            int middleIndex = leftIndex + (rightIndex - leftIndex) / 2;

            int currentRow = middleIndex / columns;
            int currentColumn = middleIndex % columns;

            if (matrix[currentRow][currentColumn] == target) {
                return true;
            } else if (matrix[currentRow][currentColumn] < target) {
                leftIndex = middleIndex + 1;
            } else {
                rightIndex = middleIndex - 1;
            }
        }

        return false;
    }

    public boolean searchMatrix_II(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;

        // Find the possible row location for target
        int row = findRow(matrix, 0, matrix.length - 1, target);
        if(row == -1) return false;

        // Find the possible column location in the row for target
        int column = findColumn(matrix[row], 0, matrix[row].length - 1, target);
        if(column == -1) return false;

        return row != -1 && column != -1;
    }

    public int findRow(int[][] matrix, int up, int down, int target){
        while(up <= down){
            int mid = up + (down - up) / 2;
            if (matrix[mid][0] > target) down = mid - 1;
            else up = mid + 1;
        }
        return down;
    }

    // Classical binary search to find the column on the row
    public int findColumn(int[] array, int left, int right, int target){
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == target) return mid;
            else if (array[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }
}
