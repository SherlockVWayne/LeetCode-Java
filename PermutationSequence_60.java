package LeetCode;

import java.util.*;

public class PermutationSequence_60 {
    public String getPermutation(int n, int k) {
        int[] factorial = new int[n + 1];
        List<Integer> values = new ArrayList<Integer>();

        factorial[0] = 1;
        for (int i = 1, f = 1; i <= n; i++) {
            f *= i;
            factorial[i] = f;
            values.add(i);
        }

        k--;

        StringBuilder result = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            int index = k / factorial[n - i];
            result.append(values.get(index));
            values.remove(index);
            k -= index * factorial[n - i];
        }
        return result.toString();
    }
}
