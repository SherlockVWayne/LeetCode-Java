package LeetCode;

public class RotateImage_48 {
    public void rotate(int[][] matrix) {
        int size = matrix.length;

        for (int i = 0; i < size; i ++) {
            for (int j = i; j < size; j ++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for (int i = 0; i < size; i ++) {
            for (int j = 0; j < (size / 2); j ++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][size - 1 - j];
                matrix[i][size - 1 - j] = temp;
            }
        }
    }
}
