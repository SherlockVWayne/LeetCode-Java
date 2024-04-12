package LeetCode;

public class ReorganizeString_767 {
    public static String reorganizeString(String S) {
        if (S == null || S.length() == 0) {
            return "";
        }
        
        int[] frequency = new int[26];
        for (char c : S.toCharArray()) {
            frequency[c - 'a'] += 1;
        }
        
        int maxFreq = 0;
        int maxFreqChar = 0;
        
        for (int i = 0; i < frequency.length; i++) {
            if (frequency[i] > maxFreq) {
                maxFreq = frequency[i];
                maxFreqChar = i;
            }
        }
        // Step I: Store all char's freq and find the max
        
        if (maxFreq > (S.length() + 1) / 2) {
            return "";
        }
        // Step II: Check if there're too many maxFreq chars
        
        // Step III: Generate result
        char[] result = new char[S.length()];
        int resultIndex = 0;
        
        // Step III.I: Make maxFreqChar evenly distributed
        // index: 0, 2, 4, 6, 8 ...
        while (frequency[maxFreqChar] > 0) {
            result[resultIndex] = (char) (maxFreqChar + 'a');
            resultIndex += 2;
            frequency[maxFreqChar]--;
        }
        // Step III.II Put the rest
        // index:
        //  i) 12, 14, 16, ...  (num of maxFreqChar < result length / 2)
        // ii) 1, 3, 5, 7, ...  (num of maxFreqChar > result length / 2)
        for (int i = 0; i < frequency.length; i++) {
            while (frequency[i] > 0) {
                if (resultIndex >= result.length) {
                    resultIndex = 1;
                }
                result[resultIndex] = (char) (i + 'a');
                resultIndex += 2;
                frequency[i]--;
            }
        }
        
        return String.valueOf(result);
    }
    
    public static void main(String[] args) {
        System.out.println(reorganizeString("aaaaaabbbccddd"));
    }
}

// No Sort O(N):

// count letter appearance and store in hash[i]
// find the letter with the largest occurrence.
// put the letter into even index numb (0, 2, 4 ...) char array
// put the rest into the array

// Time O(N): fill hash[] + find the letter + write results into char array
// Space O(N + 26): result + hash[]

// https://leetcode.com/problems/reorganize-string/discuss/232469/Java-No-Sort-O(N)-0ms-beat-100