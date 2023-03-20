package LeetCode;

import java.util.LinkedList;

public class EditDistance_72 {
    public static int minDistance(String word1, String word2) {
        // if (word1 == null || word2 == null || word1.length() == 0 || word2.length() == 0) {
        //     return 0;
        // }

        int length1 = word1.length();
        int length2 = word2.length();

        int[] dp = new int[length2 + 1];
        // dp[i] represents min distance between word1 and word2[0, i - 1]
        // e.g.    "horse"   "sor"
        // dp[0]    horse ->  ""  = 5
        // dp[1]    horse ->  s   = 4
        // dp[2]    horse ->  so  = 4
        // dp[3]    horse ->  sor = 3

        for (int i = 1; i <= length2; i++) {
            dp[i] = dp[i - 1] + 1;
        }

        for (int i = 1; i <= length1; i++) {
            int temp = dp[0];
            dp[0] = i;

            for (int j = 1; j <= length2; j++) {
                int pre = temp;
                // pre is dp[i - 1, j - 1]

                temp = dp[j];
                // record dp[j], and use in next iteration of j

                // dp[i] represents min distance
                // between word1[0, j - 1) and word2[0, i - 1)

                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    // if current char is the same
                    dp[j] = pre; // 如果word1[i]与word2[j]相等，则第i个字符对应的下标是i-1
                } else {
                    dp[j] = Math.min(Math.min(dp[j - 1], pre), dp[j]) + 1;
                }
                // (a) if we replaced c with d: dp[i][j] = dp[i-1][j-1] + 1;
                // (b) if we added d after c:   dp[i][j] = dp[i][j-1] + 1;
                // (c) if we deleted c:         dp[i][j] = dp[i-1][j] + 1;
            }
        }

        return dp[length2];
    }

    public static int minDistance_II(String word1, String word2) {
        // Write your solution here
        int[][] distance = new int[word1.length() + 1][word2.length() + 1];
        // dp[i][j] represents min distance between word1[0, i - 1] and word2[0, j - 1]
        // e.g.       "horse"  "sor"
        // dp[5][0]    horse ->  ""  = 5
        // dp[5][1]    horse ->  s   = 4
        // dp[5][2]    horse ->  so  = 4
        // dp[5][3]    horse ->  sor = 3

        for (int i = 0; i <= word1.length(); i++) {
            for (int j = 0; j <= word2.length(); j++) {
                if (i == 0) {
                    distance[i][j] = j;
                } else if (j == 0) {
                    distance[i][j] = i;
                } else if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    distance[i][j] = distance[i - 1][j - 1];
                } else {
                    distance[i][j] = Math.min(
                            distance[i][j - 1],            // add
                            Math.min(
                                    distance[i - 1][j],    // delete
                                    distance[i - 1][j - 1] // replace
                            )
                    ) + 1;
                    // (a) replaced c with d: distance[i][j] = distance[i-1][j-1] + 1;
                    // (b) added d after c:   distance[i][j] = distance[i][j-1] + 1;
                    // (c) deleted c:         distance[i][j] = distance[i-1][j] + 1;
                }
            }
        }
        Print.printInt2DArray(distance);
        return distance[word1.length()][word2.length()];
    }

    public static void main(String[] args) {
        String word1 = "horse";
        String word2 = "ros";
        System.out.println(minDistance_II(word1, word2));
        LinkedList<Integer> list = new LinkedList<Integer>();
        

    }
}
