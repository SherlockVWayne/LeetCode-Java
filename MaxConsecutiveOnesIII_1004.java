package LeetCode;

public class MaxConsecutiveOnesIII_1004 {
    public int longestOnes(int[] A, int K) {
        int start = 0;
        int end = 0;

        while (end < A.length) {
            if (A[end] == 0) K --;
            if (K < 0) {
                if (A[start] == 0) K ++;
                start++;
            }
            end ++;
        }

        return end - start;
    }
}
