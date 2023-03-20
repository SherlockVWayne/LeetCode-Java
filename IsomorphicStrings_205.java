package LeetCode;

public class IsomorphicStrings_205 {
    public static boolean isIsomorphic(String s, String t) {
        int[] memo = new int[256];
        
        for (int i = 0; i < s.length(); i++) {
            if (memo[s.charAt(i)] != memo[t.charAt(i) + 128]) {
                return false;
            }
            memo[s.charAt(i)] = i + 1;
            memo[t.charAt(i) + 128] = i + 1;
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        System.out.println(isIsomorphic("boo", "fas"));
    }
}
