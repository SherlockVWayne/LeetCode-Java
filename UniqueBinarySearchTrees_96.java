package LeetCode;

public class UniqueBinarySearchTrees_96 {
    public int numTrees(int n) {
        if (n == 0) return 0;

        int[] arr = new int[n + 1];
        arr[0] = arr[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                arr[i] += arr[j - 1] * arr[i - j];
            }
        }
        return arr[n];
    }
}
/**
 *  F(i, n) = arr(i - 1) * arr(n - i)
 *
 *  arr(n) = arr(0) * arr(n - 1) + arr(1) * arr(n - 2) + ... + arr(n - 1) * arr(0)
 */