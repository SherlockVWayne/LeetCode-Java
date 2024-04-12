package LeetCode;

import java.util.Arrays;
import java.util.HashMap;

public class BinaryTreesWithFactors_823 {
    public int numFactoredBinaryTrees(int[] A) {
        long result = 0L;
        long mod = (long) 1e9 + 7;
        Arrays.sort(A);
        HashMap<Integer, Long> dp = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            dp.put(A[i], 1L);
            for (int j = 0; j < i; j++)
                if (A[i] % A[j] == 0)
                    dp.put(A[i], (dp.get(A[i]) + dp.get(A[j]) * dp.getOrDefault(A[i] / A[j], 0L)) % mod);
            result = (result + dp.get(A[i])) % mod;
        }
        return (int) result;
    }
}

// Sort the list A at first. Scan A from small element to bigger.
//DP equation:
//dp[i] = sum(dp[j] * dp[i / j])
//res = sum(dp[i])
//with i, j, i / j in the list L
