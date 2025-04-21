package LeetCode;

public class DivideTwoIntegers_29 {
    public int divide(int dividend, int divisor) {
        if (divisor == 0) {
            throw new ArithmeticException("Divisor cannot be zero");
        }
        
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE; // overflow case
        }
        
        // Determine the sign of the result
        boolean sign = (dividend < 0) == (divisor < 0);
        
        // Use long to avoid overflow
        long absDividend = Math.abs((long) dividend);
        long absDivisor = Math.abs((long) divisor);
        
        int result = 0;
        
        while (absDividend >= absDivisor) {
            int count = 0;
            while (absDividend >= (absDivisor << (count + 1))) {
                count++;
            }
            result += 1 << count;
            absDividend -= absDivisor << count;
        }
        
        return sign ? result : -result;
    }
}
