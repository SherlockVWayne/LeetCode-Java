package LeetCode;

public class UniquePathsII_63 {
    public static int uniquePathsWithObstacles_II(int[][] obstacleGrid) {
        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;
        
        int[][] dp = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            if (obstacleGrid[i][0] != 1) {
                dp[i][0] = 1;
            } else {
                break;
            }
        }
        
        for (int i = 0; i < cols; i++) {
            if (obstacleGrid[0][i] != 1) {
                dp[0][i] = 1;
            } else {
                break;
            }
        }
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[rows - 1][cols - 1];
    }
    
    // 1. what is dp array, and what does index mean:
    // dp[i][j]: ways of getting to the point [i][j]
    // 2. Recursion formula:
    //    i) if (obstacleGrid[i][j] == 1) dp[i][j] = 0;
    //    ii) dp[i][j] = dp[i - 1][j] (DOWN) + dp[i][j - 1] (RIGHT)
    // 3. Initialize dp array:
    //    i) obstacle[i][j] == 1, then no way to get there
    //    ii) dp[0][0-n], dp[0-m][0] shoud be 1
    //    ii) BUT ONCE HIT Obstacle, all rest will be 0
    // 4. Iteration order:
    // from top->down, left->right
    // 5. Examples to check dp logic
    
    
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) return 0;
        
        int rows = obstacleGrid.length;
        int columns = obstacleGrid[0].length;
        
        int[][] arr = new int[rows][columns];
        
        for (int i = 0; i < rows; i++) {
            if (obstacleGrid[i][0] != 1) {
                arr[i][0] = 1;
            } else {
                break;
            }
        }
        
        for (int i = 0; i < columns; i++) {
            if (obstacleGrid[0][i] != 1) {
                arr[0][i] = 1;
            } else {
                break;
            }
        }
        
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < columns; j++) {
                if (obstacleGrid[i][j] != 1) {
                    arr[i][j] = arr[i][j - 1] + arr[i - 1][j];
                }
            }
        }
        
        return arr[rows - 1][columns - 1];
    }
}
