package LeetCode;

public class LargestLocalValuesInAMatrix_2373 {
    public int[][] largestLocal(int[][] grid) {
        int newSize = grid.length - 2;
        int[][] result = new int[newSize][newSize];
        
        for (int i = 1; i < newSize + 1; ++i) {
            for (int j = 1; j < newSize + 1; ++j) {
                int temp = 0;
                
                for (int k = i - 1; k <= i + 1; ++k) {
                    for (int l = j - 1; l <= j + 1; ++l) {
                        temp = Math.max(temp, grid[k][l]);
                    }
                }
                
                result[i - 1][j - 1] = temp;
            }
        }
        
        return result;
    }
}
