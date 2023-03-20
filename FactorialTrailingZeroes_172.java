package LeetCode;

public class FactorialTrailingZeroes_172 {
    public int trailingZeroes(int n) {
        int count = 0;

        while (n != 0) {
            int temp = n / 5;
            count += temp;
            n = temp;
        }
        return count;
    }

    public int trailingZeroesII(int n) {
        return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
    }
}
