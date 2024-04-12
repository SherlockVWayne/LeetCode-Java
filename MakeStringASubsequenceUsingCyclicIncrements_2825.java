package LeetCode;

public class MakeStringASubsequenceUsingCyclicIncrements_2825 {
    public boolean canMakeSubsequence(String str1, String str2) {
        if (str2 == null || str2.length() == 0) {
            return true;
        }
        
        if (str1 == null || str1.length() == 0 || str2.length() > str1.length()) {
            return false;
        }
        
        int str1Index = 0;
        int str2Index = 0;
        
        while (str1Index < str1.length()) {
            if (str1.charAt(str1Index) == str2.charAt(str2Index) ||
                str1.charAt(str1Index) + 1 == str2.charAt(str2Index) ||
                str1.charAt(str1Index) - 25 == str2.charAt(str2Index)
            ) {
                str2Index++;
                if (str2Index == str2.length()) {
                    return true;
                }
            }
            str1Index++;
        }
        return false;
    }
    
    public boolean canMakeSubsequence_II(String str1, String str2) {
        if (str2 == null || str2.length() == 0) {
            return true;
        }
        
        if (str1 == null || str1.length() == 0 || str2.length() > str1.length()) {
            return false;
        }
        
        int str1Index = 0;
        int str2Index = 0;
        char[] str11 = str1.toCharArray();
        char[] str22 = str2.toCharArray();
        
        while (str1Index < str11.length) {
            if (
                // str11[str1Index] == str22[str2Index] ||
                // str11[str1Index] + 1 == str22[str2Index] ||
                // str11[str1Index] - 25 == str22[str2Index]
                (str22[str2Index] - str11[str1Index] + 26) % 26 <= 1
            ) {
                str2Index++;
                if (str2Index == str2.length()) {
                    return true;
                }
            }
            str1Index++;
        }
        return false;
    }
}
