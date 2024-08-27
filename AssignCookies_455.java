package LeetCode;

import java.util.Arrays;

public class AssignCookies_455 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        
        int gPointer = 0;
        int sPointer = 0;
        
        while (gPointer < g.length && sPointer < s.length) {
            if (g[gPointer] <= s[sPointer]) {
                gPointer++;
                sPointer++;
            } else {
                sPointer++;
            }
        }
        
        return gPointer;
    }
    
    public int findContentChildren_II(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        
        int result = 0;
        int j = s.length - 1;
        for (int i = g.length - 1; i >= 0; i--) {
            if (j >= 0 && s[j] >= g[i]) {
                result++;
                j--;
            }
        }
        return result;
    }
}
