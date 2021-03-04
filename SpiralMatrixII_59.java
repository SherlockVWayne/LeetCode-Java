package LeetCode;

public class SpiralMatrixII_59 {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];

        if (n == 0) return result;

        int rowBegin = 0;
        int rowEnd = n - 1;
        int columnBegin = 0;
        int columnEnd = n - 1;

        int counter = 1;

        while (rowBegin <= rowEnd && columnBegin <= columnEnd) {

            // ——>
            for (int i = columnBegin; i <= columnEnd; i++) {
                result[rowBegin][i] = counter ++;
            }
            rowBegin++;

            // ↓
            for (int i = rowBegin; i <= rowEnd; i ++) {
                result[i][columnEnd] = counter ++;
            }
            columnEnd--;

            // <——
            if (rowBegin <= rowEnd){
                for (int i = columnEnd; i >= columnBegin; i --) {
                    result[rowEnd][i] = counter ++;
                }
            }
            rowEnd--;

            // ↑
            if (columnBegin <= columnEnd){
                for (int i = rowEnd; i >= rowBegin; i --) {
                    result[i][columnBegin] = counter ++;
                }
            }
            columnBegin++;
        }

        return result;
    }
}
