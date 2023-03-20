package LeetCode;
import java.io.*;

public class HappyNumber_202 {
    public static boolean isHappy(int n) {
        int slow = n;
        int fast = n;

        while (true) {
            slow = getNextNumber(slow);
            fast = getNextNumber(fast);
            fast = getNextNumber(fast);
            if (slow == fast) break;
        }
        return slow == 1;
    }

    private static int getNextNumber(int n) {
        int count = 0;
        while (n > 0) {
            count += (n % 10) * (n % 10);
            n /= 10;
        }
        return count;
    }

}
