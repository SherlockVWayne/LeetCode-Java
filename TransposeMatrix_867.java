package LeetCode;

public class TransposeMatrix_867 {
    public int[][] transpose(int[][] A) {
        int rows = A.length;
        int columns = A[0].length;

        int[][] result = new int[columns][rows];

        for (int i = 0; i < rows; i ++) {
            for (int j = 0; j < columns; j ++) {
                result[j][i] = A[i][j];
            }
        }

        return result;
    }
}
