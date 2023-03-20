package LeetCode;

public class MinimumSidewayJumps_1824 {
    public int minSideJumps(int[] obstacles) {
        int[] dp = new int[]{1, 0, 1};
        for (int a : obstacles) {
            if (a > 0)
                dp[a - 1] = 1000000;
            for (int i = 0; i < 3; ++i)
                if (a != i + 1)
                    dp[i] = Math.min(dp[i], Math.min(dp[(i + 1) % 3], dp[(i + 2) % 3]) + 1);
        }
        return Math.min(dp[0], Math.min(dp[1], dp[2]));
    }
}
/**
 * dp[0] = minimum jump to reach lane 1
 * dp[1] = minimum jump to reach lane 2
 * dp[2] = minimum jump to reach lane 3
 * If meet a stone, set its dp[i] to infinity.
 * result equals to min(dp)
 * <p>
 * <p>
 * Complexity
 * Time O(n)
 * Space O(1)
 */

// We only need to check for two things:
//
// 1. If we see '//' we stop reading the current line, and add whatever characters we have seen to the result.
// 2. If we see '/*' then we start the multiline comment mode and we keep on ignoring characters until we see '*/'.
// 3. If the current character is neither of the above two and the multiline comment mode is off, then we add that character to the current line.
// Once we parse one line (source[i]), then if the mode is off, we add the currently generated line (StringBuilder) to the result and repeat for source[i + 1].
