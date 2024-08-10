package LeetCode;

public class MaximumScoreAfterSplittingAString_1422 {
    public int maxScore(String s) {
        int zeroFromLeft = 0;
        int oneFromRight = (int) s.chars().filter(c -> c == '1').count();
        
        int maxScore = 0;
        
        for (int i = 0; i < s.length() - 1; i++) {
            // if there is not "s.length() - 1"
            // for s = "00" it'll return 2 instead of 1
            // we want non-empty substrings
            
            zeroFromLeft += s.charAt(i) == '0' ? 1 : 0;
            oneFromRight -= s.charAt(i) == '1' ? 1 : 0;
            maxScore = Math.max(maxScore, zeroFromLeft + oneFromRight);
        }
        return maxScore;
    }
}

// Time complexity:
// O(n), where nnn is the length of the input string. We iterate through the string once.
// Space complexity:
// O(1). We use a constant amount of extra space for the counts and the maximum score variable.
