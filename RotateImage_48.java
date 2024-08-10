package LeetCode;

public class RotateImage_48 {
    public static void rotate(int[][] matrix) {
        int size = matrix.length;
        
        for (int i = 0; i < size; i++) {
            for (int j = i; j < size; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        Print.printInt2DArray(matrix);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < (size / 2); j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][size - 1 - j];
                matrix[i][size - 1 - j] = temp;
            }
        }
        Print.printInt2DArray(matrix);
    }
    
    public static void main(String[] args) {
        rotate(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
    }
}
