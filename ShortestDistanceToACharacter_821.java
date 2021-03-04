package LeetCode;

public class ShortestDistanceToACharacter_821 {
    public int[] shortestToChar(String s, char c) {
        int n = s.length();
        int[] result = new int[n];
        int currentPosition = -n;

        for (int i = 0; i < n; i ++) {
            if (s.charAt(i) == c) {
                currentPosition = i;
            }
            result[i] = i - currentPosition;
        }

        for (int i = n - 1; i >= 0; i --) {
            if (s.charAt(i) == c) {
                currentPosition = i;
            }
            result[i] = Math.min(result[i], Math.abs(i - currentPosition));
        }
        return result;
    }
}
