package LeetCode;

public class IsSubsequence_392 {
    public boolean isSubsequence(String s, String t) {
        if (s == null || s.length() == 0) {
            return true;
        }
        
        if (t == null || t.length() == 0 || s.length() > t.length()) {
            return false;
        }
        
        int sIndex = 0;
        int tIndex = 0;
        
        while (tIndex < t.length()) {
            if (s.charAt(sIndex) == t.charAt(tIndex)) {
                sIndex++;
                if (sIndex == s.length()) {
                    return true;
                }
            }
            tIndex++;
        }
        return false;
    }
    
    public boolean isSubsequence_II(String s, String t) {
        if (s == null || s.length() == 0) {
            return true;
        }
        
        if (t == null || t.length() == 0 || s.length() > t.length()) {
            return false;
        }
        
        int sIndex = 0;
        int tIndex = 0;
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();
        
        while (tIndex < tt.length) {
            if (ss[sIndex] == tt[tIndex]) {
                sIndex++;
                if (sIndex == ss.length) {
                    return true;
                }
            }
            tIndex++;
        }
        
        return false;
    }
}
