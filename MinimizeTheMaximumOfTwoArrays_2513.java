package LeetCode;

public class MinimizeTheMaximumOfTwoArrays_2513 {
    public static int minimizeSet(int divisor1, int divisor2, int uniqueCnt1, int uniqueCnt2) {
        int gcd = divisor1;
        for (int x = divisor2; x > 0; ) {
            int tmp = gcd;
            gcd = x;
            x = tmp % x;
        }
        long low = 0;
        long high = Integer.MAX_VALUE;
        long lcm = ((long) divisor1 * divisor2 / gcd); // least common multiple
        while (low < high) {
            long mid = low + (high - low) / 2;
            if (uniqueCnt1 <= mid - mid / divisor1 &&
                uniqueCnt2 <= mid - mid / divisor2 &&
                uniqueCnt1 + uniqueCnt2 <= mid - mid / lcm)
                high = mid;
            else low = mid + 1;
        }
        return (int) low;
    }
    
    public static void main(String[] args) {
        System.out.println(minimizeSet(24, 16, 3, 4));
    }
}
//Intuition
//Here, we can use binary search to look for the tightest upper bound.
// Given a value x, the condition for x to be a valid upper bound is that
//
//there is enough number between 1 to x that are not divisible by divisor1;
//there is enough number between 1 to x that are not divisible by divisor2;
//in the overlapping area, if some numbers are allocated to cover uniqueCnt1 they cannot be used to cover uniqueCnt2.
