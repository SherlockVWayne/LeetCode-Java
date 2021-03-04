package LeetCode;

public class EditDistance_72 {
    public int minDistance(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();
        int[] dp = new int [n2 + 1];
        for (int i = 1; i <= n2; i++)
            dp[i] = dp[i-1] + 1;
        for (int i = 1; i <= n1; i++) {
            int temp = dp[0];
            dp[0] = i;
            for (int j = 1; j <= n2; j++) {
                int pre = temp; // pre相当于之前的dp[i-1,j-1]
                temp = dp[j];
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[j] = pre;  // 如果word1[i]与word2[j]相等，则第i个字符对应的下标是i-1
                } else {
                    dp[j] = Math.min(Math.min(dp[j-1], pre), dp[j]) + 1;
                }
            }
        }
        return dp[n2];
    }
}
