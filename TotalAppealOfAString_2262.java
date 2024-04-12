package LeetCode;

public class TotalAppealOfAString_2262 {
    public static long appealSum(String s) {
        int[] last = new int[26];
        long result = 0;
        for (int i = 0; i < s.length(); ++i) {
            last[s.charAt(i) - 'a'] = i + 1;
            for (int j : last)
                result += j;
        }
        return result;
    }
    
    public static void main(String[] args) {
        System.out.println(appealSum("abbca"));
    }
}
// Time O(n)
// Space O(26)
