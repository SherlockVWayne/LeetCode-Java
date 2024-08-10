package LeetCode;

import java.util.Arrays;
import java.util.List;

public class LargestMultipleOfThree_1363 {
    public String largestMultipleOfThree(int[] digits) {
        Arrays.sort(digits);
        int sum = 0;
        int[] numCounts = new int[10];
        for (int digit : digits) {
            numCounts[digit]++;
            sum += digit;
        }
        if (sum == 0) {
            return "0";
        }
        
        return solve(numCounts, sum, sum % 3);
    }
    
    private String solve(int[] numCounts, int sum, int currentMod) {
        if (currentMod == 0) {
            buildResult(numCounts);
        }
        int mod = currentMod;
        
        while (sum % 3 != 0) {
            // e.g., sum % 3 == 2, it means we need to:
            // 1. if having 2, 5, 8,     remove them
            // 2. if not having 2, 5, 8, meaning having even numbers of 1, 4, 7, remove 2 digits of them
            if (numCounts[mod] > 0) { // if having 2
                sum -= mod;
                numCounts[mod]--;
            }
            
            if (mod % 3 == currentMod || numCounts[mod] <= 0) { // if not having 2, but might have 5 or 8
                mod += 3;
            }
            if (mod > 9) { // if not having 2, 5, 8, then we need to remove 2 digits of 1, 4, 7
                mod = (mod + mod) % 3;
            }
        }
        return buildResult(numCounts);
    }
    
    private String buildResult(int[] numCounts) {
        StringBuilder sb = new StringBuilder();
        for (int i = 9; i >= 0; i--) {
            if (i == 0 && numCounts[i] > 0 && sb.length() == 0) {
                // {0, 0, 0, 0, 1} should print out "0", not "0000"
                return "0";
            }
            // for (int j = 0; j < numCounts[i]; j++) {
            //     sb.append(i);
            // }
            sb.append(String.valueOf(i).repeat(Math.max(0, numCounts[i])));
        }
        return sb.toString();
    }
}
