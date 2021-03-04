package LeetCode;

public class SqrtX_69 {
    public int mySqrt(int x) {
        long left = 0;
        long right = x;

        while (left + 1 < right) {
            long middle = left + (right - left) / 2;

            if (middle * middle == x) {
                return (int) middle;
            } else if (middle * middle < x) {
                left = middle;
            } else {
                right = middle;
            }
        }

        if (right * right == x) {
            return (int) right;
        }

        return (int) left;
    }
}
