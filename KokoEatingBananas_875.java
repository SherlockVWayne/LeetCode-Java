package LeetCode;

import java.util.Arrays;

public class KokoEatingBananas_875 {
    public static int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        
        int right = piles[0];
        for (int pile : piles) {
            right = Math.max(pile, right);
        }
        
        while (left < right) {
            int middle = left + (right - left) / 2;
            if (canEatInTime(piles, middle, h)) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }
        
        return left;
    }
    
    private static boolean canEatInTime(int[] piles, int k, long hourLimit) {
        int hours = 0;
        for (int pile : piles) {
            // pile / k => 10 / 4 = 2
            // pile % k => 2, so we need to have one more hour to eat remaining bananas left over as remainder
            // hours = 3;
            int hoursForThisPile = pile / k;
            hours += hoursForThisPile;
            // if remainder value is not 0, we need to have an extra hour
            if (pile % k != 0 || (hoursForThisPile * k != pile)) {
                hours++;
            }
        }
        
        return hours <= hourLimit;
    }
    
    public static void main(String[] args) {
        System.out.println(minEatingSpeed(new int[]{805_306_368, 805306368, 805306368}, 1_000_000_000));
        System.out.println(805_306_368 % 3);
    }
}
//    Time Complexity : O(N * log(M)) where N is no of piles & M is range of K (left to right)
//
//    Space Complexity : O(1) as not using any extra space


//   805,306,368,805306368,805306368
// 1,000,000,000

// When mid equals to 1, the hours would be 2415919104 which overflows the int type.
// The maximum of int type is 2147483647. The overflowed value would be -1879048192 in int type
// less than 1000000000 causing the failure.
// The problem can be solved only change the type of hours into type long which prevent overflow