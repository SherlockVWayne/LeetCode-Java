package LeetCode;

public class SmallestRangeI_908 {
    public int smallestRangeI(int[] A, int K) {
        int minVal = A[0];
        int maxVal = A[0];
        for (int i = 0; i < A.length; i ++) {
            minVal = Math.min(A[i], minVal);
            maxVal = Math.max(A[i], maxVal);
        }
        if (minVal + K >= maxVal - K) {
            return 0;
        } else {
            return (maxVal - K) - (minVal + K);
        }
    }
}
