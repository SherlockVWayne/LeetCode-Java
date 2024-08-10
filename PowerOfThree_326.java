package LeetCode;

public class PowerOfThree_326 {
    public boolean isPowerOfThree(int n) {
        return n == 0 ? false : (n == 1 ? true : n % 3 == 0 ? isPowerOfThree(n / 3) : false);
    }
}
