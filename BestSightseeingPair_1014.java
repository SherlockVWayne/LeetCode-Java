package LeetCode;

public class BestSightseeingPair_1014 {
    public int maxScoreSightseeingPair(int[] values) {
        int[] suffixSum = new int[values.length];
        suffixSum[values.length - 1] = values[values.length - 1] - (values.length - 1);
        
        for (int i = values.length - 2; i >= 0; i--) {
            suffixSum[i] = Math.max(suffixSum[i + 1], values[i] - i);
        }
        
        int maxScore = Integer.MIN_VALUE;
        for (int i = 0; i < values.length - 1; i++) {
            maxScore = Math.max(maxScore, suffixSum[i + 1] + values[i] + i);
        }
        return maxScore;
    }
}
