package LeetCode;

public class FibonacciNumber_509 {
    public int fib(int n) {
        return (n == 0) ? 0 : ((n == 1) ? 1 : fib(n - 1) + fib(n - 2));
    }

    public int fibII(int N) {
        if(N <= 1) return N;
        int a = 0, b = 1;

        while(N-- > 1) {
            int sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }
}
