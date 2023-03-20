package LeetCode;

public class NumberOfWaysOfCuttingAPizza_1444 {
    static int level = 0;

    public static int ways(String[] pizza, int k) {
        if (pizza == null || pizza.length == 0 || pizza[0].length() == 0) {
            return -1;
        }
        int rows = pizza.length;
        int cols = pizza[0].length();

        Integer[][][] dp = new Integer[k][rows][cols];
        // dp[k][i][j]: k cuts remaining, how many valid cutting in pizza[i:rows][j:cols]
        int[][] preSum = new int[rows + 1][cols + 1];
        // preSum[i][j]: total number of apples in pizza[i:rows][j:cols]
        for (int row = rows - 1; row >= 0; row--) {
            for (int col = cols - 1; col >= 0; col--) {
                preSum[row][col] = preSum[row + 1][col] + preSum[row][col + 1]
                        - preSum[row + 1][col + 1] + ((pizza[row].charAt(col) == 'A') ? 1 : 0);
            }
        }
        int ans = dfs(rows, cols, k - 1, 0, 0, dp, preSum);

        return ans;
    }

    /**
     * @param rows       total rows
     * @param cols       total cols
     * @param k          remaining usable cuts including this cut in this recursion
     * @param currentRow current row
     * @param currentCol current col
     * @param dp
     * @param preSum
     * @return
     */
    public static int dfs(int rows, int cols, int k, int currentRow, int currentCol, Integer[][][] dp, int[][] preSum) {
        if (preSum[currentRow][currentCol] == 0) return 0; // if the remain piece has no apple -> invalid
        if (k == 0) return 1; // found valid way after using k-1 cuts
        if (dp[k][currentRow][currentCol] != null) return dp[k][currentRow][currentCol];
        int ans = 0;
        level = level + 1;
        // cut in horizontal
        for (int nextRow = currentRow + 1; nextRow < rows; nextRow++)
            if (preSum[currentRow][currentCol] - preSum[nextRow][currentCol] > 0) // cut if the upper piece contains at least one apple
                ans = (ans + dfs(rows, cols,
                        k - 1, // already cut between preSum[currentRow][] and preSum[nextRow][]
                        nextRow, currentCol, dp, preSum)) % 1_000_000_007;
        // cut in vertical
        for (int nextCol = currentCol + 1; nextCol < cols; nextCol++)
            if (preSum[currentRow][currentCol] - preSum[currentRow][nextCol] > 0) // cut if the left piece contains at least one apple
                ans = (ans + dfs(rows, cols,
                        k - 1, // already cut between preSum[][currentCol] and preSum[][nextCol]
                        currentRow, nextCol, dp, preSum)) % 1_000_000_007;

        dp[k][currentRow][currentCol] = ans;

//        System.out.println("current level: " + level);
//        System.out.println("k = " + k + ",ans = " + ans + ", Current dp:");
//        for (Integer y = 0; y < rows; y++) {
//            for (Integer z = 0; z < cols; z++) {
//                if (z == cols - 1) {
//                    System.out.print(dp[k][y][z] + " ");
//                    System.out.println();
//                } else System.out.print(dp[k][y][z] + " ");
//            }
//            if (y == rows - 1) System.out.println();
//        }
//        System.out.println();

        return ans;
    }

    public static void main(String[] args) {
        String[] pizza = new String[]{"A..", "AAA", "..."};
        int k = 3;
        System.out.println(ways(pizza, k));
    }
}
