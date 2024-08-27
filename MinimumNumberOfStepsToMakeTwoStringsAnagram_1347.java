package LeetCode;

public class MinimumNumberOfStepsToMakeTwoStringsAnagram_1347 {
    public int minSteps(String s, String t) {
        int[] charCounts = new int[26];
        
        for (int i = 0; i < s.length(); i++) {
            charCounts[s.charAt(i) - 'a'] += 1;
            charCounts[t.charAt(i) - 'a'] -= 1;
        }
        
        int result = 0;
        for (int count : charCounts) {
            result += count > 0 ? count : 0;
        }
        return result;
    }
}
// Time: O(n)
// Space: O(1), where n = s.length() + t.length().
