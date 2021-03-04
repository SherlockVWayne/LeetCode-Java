package LeetCode;

public class PowXN_50 {
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        if (x == 0) return 0;

        if (n == Integer.MIN_VALUE) {
            x *= x;
            n /= 2;
        }

        if (n < 0) {
            n = -n;
            x = 1 / x;
        }
        return (n % 2 == 0) ? myPow(x * x, n / 2) : myPow(x * x, n / 2) * x;
    }
}
