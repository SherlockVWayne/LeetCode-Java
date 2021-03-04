package LeetCode;

import java.util.*;

public class OddEvenJump_975 {

    public int oddEvenJumps(int[] A) {
        int goodStartingIndexCount = 1;
        int n = A.length;

        boolean[] higher = new boolean[n];
        boolean[] lower = new boolean[n];

        higher[n - 1] = true;
        lower[n - 1] = true;

        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        treeMap.put(A[n - 1], n - 1);

        for (int i = n - 2; i >= 0; i --) {
            Map.Entry higherKeyValuePair = treeMap.ceilingEntry(A[i]);
            Map.Entry lowerKeyValuePair = treeMap.floorEntry(A[i]);

            if (higherKeyValuePair != null) {
                higher[i] = lower[(int)higherKeyValuePair.getValue()];
            }

            if (lowerKeyValuePair != null) {
                lower[i] = higher[(int)lowerKeyValuePair.getValue()];
            }

            if (higher[i]) {
                goodStartingIndexCount ++;
            }

            treeMap.put(A[i], i);
        }
        return goodStartingIndexCount;
    }

    public int oddEvenJumpsII(int[] A) {
        int n  = A.length, res = 1;
        boolean[] higher = new boolean[n], lower = new boolean[n];
        higher[n - 1] = lower[n - 1] = true;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(A[n - 1], n - 1);
        for (int i = n - 2; i >= 0; --i) {
            Map.Entry<Integer, Integer> hi = map.ceilingEntry(A[i]), lo = map.floorEntry(A[i]);
            if (hi != null) higher[i] = lower[(int)hi.getValue()];
            if (lo != null) lower[i] = higher[(int)lo.getValue()];
            if (higher[i]) res++;
            map.put(A[i], i);
        }
        return res;
    }
}
