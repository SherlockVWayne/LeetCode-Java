package LeetCode;

public class FibonacciNumber_509 {
    public static int fib_III(int n) {
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            if (i == 0) {
                dp[i] = 0;
            } else if (i == 1) {
                dp[i] = 1;
            } else {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
        }
        return dp[n];
    }
    
    public static void main(String[] args) {
        System.out.println(fib_III(4));
    }
    
    public int fib_IV(int n) {
        int[] dp = new int[]{0, 1};
        for (int i = 0; i < n - 1; i++) {
            int temp = dp[0] + dp[1];
            dp[0] = dp[1];
            dp[1] = temp;
        }
        return dp[1];
    }
    
    public int fib(int n) {
        return (n == 0) ? 0 : ((n == 1) ? 1 : fib(n - 1) + fib(n - 2));
    }
    
    // 1. what is dp array, and what does index mean:
    // dp[i]: i-th fibo number
    // 2. Recursion formula:
    // dp[i] = dp[i - 1] + dp[i - 2]
    // 3. Initialize dp array:
    // dp[0] = 0, dp[1] = 1
    // 4. Iteration order:
    // from 0 -> n (top down)
    // 5. Examples to check dp logic
    
    public int fibII(int N) {
        if (N <= 1) return N;
        int a = 0, b = 1;
        
        while (N-- > 1) {
            int sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }
}
