package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClosestPrimeNumbersInRange_2523 {
    
    public static void main(String[] args) {
        Print.printIntArray(new ClosestPrimeNumbersInRange_2523().closestPrimes(10, 19));
    }
    
    public int[] closestPrimes(int left, int right) {
        if (left == right || left + 1 == right) {
            return new int[]{-1, -1};
        }
        
        boolean[] primeBoolean = sieve(right);
        List<Integer> primes = new ArrayList<>();
        
        for (int i = left; i <= right; i++) {
            if (primeBoolean[i]) {
                primes.add(i);
            }
        }
        int currMinDistance = Integer.MAX_VALUE;
        int[] result = new int[]{-1, -1};
        for (int i = 1; i < primes.size(); i++) {
            if (primes.get(i) - primes.get(i - 1) < currMinDistance) {
                result[0] = primes.get(i - 1);
                result[1] = primes.get(i);
                currMinDistance = primes.get(i) - primes.get(i - 1);
            }
        }
        return result;
    }
    
    private boolean[] sieve(int right) {
        boolean[] result = new boolean[right + 1];
        Arrays.fill(result, true);
        result[0] = false;
        result[1] = false;
        for (int prime = 2; prime < right + 1; prime++) {
            if (result[prime]) {
                for (int index = prime + prime; index <= right; index += prime) {
                    result[index] = false;
                }
            }
        }
        
        return result;
    }
}
