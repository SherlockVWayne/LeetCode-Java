package LeetCode;

import java.util.Arrays;
import java.util.stream.IntStream;

public class PlatesBetweenCandles_2055 {
    
    public static int[] platesBetweenCandles_II(String s, int[][] queries) {
        int[] preSum = new int[s.length() + 1];
        int[] next = new int[s.length() + 1]; // store right-closest candle index
        int[] prev = new int[s.length() + 1]; // store left-closest  candle index
        // index      :   0  1  2  3  4  5  6  7  8  9
        // s          :   *  *  |  *  *  |  *  *  |  *
        // preSum     :   0  0  0  1  1  1  2  2  2  3  3   how many candles from left
        // next       :   2  2  2  5  5  5  8  8  8  M  M
        // next                    l
        // prev       :   0  0  0  2  2  2  5  5  5  8  8
        // prev                                         r
        // query [3, 9]:           ^                 ^
        
        
        Arrays.fill(next, Integer.MAX_VALUE);
        int[] result = new int[queries.length];
        
        for (int i = 0; i < s.length(); i++) {
            preSum[i + 1] = preSum[i] + (s.charAt(i) == '|' ? 1 : 0);
            prev[i + 1] = s.charAt(i) == '|' ? i : prev[i];
        }
        
        for (int i = s.length() - 1; i >= 0; i--) {
            next[i] = s.charAt(i) == '|' ? i : next[i + 1];
        }
        
        for (int i = 0; i < queries.length; i++) {
            int leftFirstCandleIndex = next[queries[i][0]];       // At startIndex looking to right, the index of first candle
            int rightFirstCandleIndex = prev[queries[i][1] + 1];  // At endIndex   looking to left,  the index of first candle
            result[i] = leftFirstCandleIndex < rightFirstCandleIndex ?
                rightFirstCandleIndex - leftFirstCandleIndex - (preSum[rightFirstCandleIndex] - preSum[leftFirstCandleIndex]) :
                // index      :   0  1  2  3  4  5  6  7  8  9
                // s          :   *  *  |  *  *  |  *  *  |  *
                // 8 - 5 - (2 - 1)
                0;
        }
        return result;
    }
//    We can count candles between two positions in O(1) using a prefix sum array dp. Before we can do that, we need to find the leftmost (first) and rightmost (last) candle for each query.
//
//    We can also do it in O(1) by tracking next and prev candle for each position on the table.
//
//    The time complexity of this solution is O(n + m), where n is the number of queries, and m - the length of the string.
    
    
    public static int[] platesBetweenCandles(String s, int[][] queries) {
        if (s == null || s.length() == 0) {
            return new int[]{};
        }
        int[] result = new int[queries.length];
        
        int[] preSum = new int[s.length()];
        // index      :   0  1  2  3  4  5  6  7  8  9
        // s          :  '*  *  |  *  *  |  *  *  |  *'
        // candles    :   0  0  1  1  1  2  2  2  3  3
        // plates     :   1  2  2  3  4  4  5  6  6  7
        // query [3, 9]:           ^                 ^
        
        preSum[0] = s.charAt(0) == '*' ? 1 : 0;
        
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '*') {
                // plates += 1
                preSum[i] = preSum[i - 1] + 1;
            } else if (s.charAt(i) == '|') {
                preSum[i] = preSum[i - 1];
            }
        }
        
        for (int i = 0; i < result.length; i++) {
            result[i] = countPlates(s, preSum, queries[i][0], queries[i][1]);
        }
        
        return result;
    }
    
    private static int countPlates(String s, int[] preSum, int startIndex, int endIndex) {
        if (preSum[endIndex] - preSum[startIndex] == endIndex - startIndex) return 0;
        
        int firstCandleIndex = IntStream.range(startIndex, endIndex + 1) // Create an IntStream for index values
            .filter(i -> s.charAt(i) == '|') // Filter indexes where the character is '|'
            .findFirst() // Find the first occurrence
            .orElse(-1); // Return -1 if not found
        
        int lastCandleIndex = IntStream.iterate(endIndex, i -> i - 1) // Iterate in reverse order
            .limit(endIndex - startIndex + 1) // Limit to the length of the string
            .filter(i -> i >= startIndex) // Ensure the index is within the range
            .filter(i -> s.charAt(i) == '|') // Filter indexes where the character is '|'
            .findFirst() // Find the first occurrence (which is actually the last in the original string)
            .orElse(-1);
        
        return preSum[lastCandleIndex] - preSum[firstCandleIndex];
    }
    
    public static void main(String[] args) {
        Print.printIntArray(platesBetweenCandles_II("**|**|**|*", new int[][]{{3, 9}, {4, 6}, {4, 5}, {2, 5}}));
    }
}
