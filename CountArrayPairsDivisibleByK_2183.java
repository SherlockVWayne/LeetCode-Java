package LeetCode;

import java.util.*;

public class CountArrayPairsDivisibleByK_2183 {
    
    //              96,   45,   65   | k = 60
    // GCD with 60: 12    15    5
    //              (12 * 15) % 60 == 0 ? result += 1 : result += 0;
    public static long countPairs(int[] nums, int k) {
        Map<Integer, Integer> greatestCommonDivisorMap = new HashMap<>();
        
        long result = 0;
        for (int num : nums) {
            int currentGCD = greatestCommonDivisor(num, k);
            
            for (Map.Entry<Integer, Integer> e : greatestCommonDivisorMap.entrySet()) {
                int GCD = e.getKey();
                int counts = e.getValue();
                //convert to long to avoid i * j overflow error
                result += (long) currentGCD * GCD % k == 0 ? counts : 0;
            }
            //              96,    45,   65 , ...
            // GCD with 60: 12     15     5    15   15   15
            // gcdMap     : 12(1)  15(4)  5(1)
            // if currentGCD == 4: result += map.get(15)
            greatestCommonDivisorMap.put(currentGCD, greatestCommonDivisorMap.getOrDefault(currentGCD, 0) + 1);
        }
        return result;
    }
    
    private static int greatestCommonDivisor(int bigger, int smaller) {
        if (bigger < smaller) {
            return greatestCommonDivisor(smaller, bigger);
        }
        if (bigger % smaller == 0) {
            return smaller;
        }
        return greatestCommonDivisor(smaller, bigger % smaller);
    }
    
    // GCD: Greatest common divisor
    public static long countPairs_II(int[] nums, int k) {
        Map<Long, Long> cnt = new HashMap<>();
        long result = 0L;
        for (int x : nums) {
            cnt.merge(java.math.BigInteger.valueOf(x).gcd(java.math.BigInteger.valueOf(k)).longValue(), 1L, Long::sum);
        }
        for (long x : cnt.keySet()) {
            for (long y : cnt.keySet()) {
                if (x <= y && x * y % k == 0L) {
                    result += x < y ? cnt.get(x) * cnt.get(y) : cnt.get(x) * (cnt.get(x) - 1L) / 2L;
                }
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
        System.out.println(countPairs(new int[]{1, 2, 3, 4, 5}, 2));
    }
}
