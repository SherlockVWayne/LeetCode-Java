package LeetCode;

public class ValidPerfectSquare_367 {
    public static void main(String[] args) {
//        System.out.println(Math.sqrt(2147483647));
        System.out.println(isPerfectSquare(Integer.MAX_VALUE));
//        System.out.println(2147483647);
//        System.out.println(Integer.MAX_VALUE);
    }
    
    public static boolean isPerfectSquare(int num) {
        long left = 1;
        long right = num / 2 + 1;
        while (left + 1 < right) {
            long middle = left + (right - left) / 2;
            if (middle * middle == num) {
                return true;
            } else if (middle * middle < num) {
                left = middle;
            } else {
                right = middle;
            }
        }
        return left * left == num || right * right == num;
    }
}
