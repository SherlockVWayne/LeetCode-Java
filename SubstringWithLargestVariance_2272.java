package LeetCode;

public class SubstringWithLargestVariance_2272 {
    public static int largestVariance(String s) {
        if (s == null || s.length() == 0) return -1;
        int[] frequency = new int[26];
        // use an array to keep freq of each char
        for (char c : s.toCharArray()) {
            frequency[c - 'a']++;
        }
        
        int maxVariance = 0;
        
        // check for every possible pair of chars with assumption:
        // one char is greater than the other
        // in the below:
        // assume charB > charA
        for (int charA = 0; charA < 26; charA++) {
            for (int charB = 0; charB < 26; charB++) {
                int remainingCharA = frequency[charA];
                int remainingCharB = frequency[charB];
                if (charA == charB || // skip when charA is same as charB
                    remainingCharA == 0 || remainingCharB == 0 // iterate to possible pair
                ) {
                    continue;
                }
                
                int currentFreqA = 0;
                int currentFreqB = 0;
                for (int i = 0; i < s.length(); i++) {
                    int currentChar = s.charAt(i) - 'a';
                    
                    if (currentChar == charB) {
                        currentFreqB++;
                    }
                    if (currentChar == charA) {
                        currentFreqA++;
                        remainingCharA--;
                    }
                    
                    if (currentFreqB < currentFreqA &&
                        // reset counter only if we know
                        // there are more c1 chars to come in the iteration
                        remainingCharA >= 1
                        // remainingCharA >= 1 is required
                        // for the test case "yxx" and charA = y && charB = x
                        // we are assuming that freq B is larger than freq A.
                        // in this case, we have to make sure for every candidate substring, there must be at least one A.
                        // Substring with only all B (bbbbbbb) is not a valid one
                    ) {
                        currentFreqA = 0;
                        currentFreqB = 0;
                    }
                    
                    if (currentFreqA > 0 && currentFreqB > 0) {
                        maxVariance = Math.max(maxVariance, currentFreqB - currentFreqA);
                    }
                }
            }
        }
        return maxVariance;
    }
    
    public static void main(String[] args) {
        System.out.println(largestVariance("aabdacdebbb"));
        
    }
}

// for (freqA : freqArray)
//    for (freqB : freqArray)
//        for (c : s.toCharArray())
// for each pair of charA and charB, iterate the string to find the max variance


// Time = O(26 * 26 * n)

// For every possible character pair a(min freq) & b(max freq),
// find the substring with the max differenct
// between the freq of a & b which can be done using kadanes algorithm.

// kadanes algorithm:
// https://medium.com/@rsinghal757/kadanes-algorithm-dynamic-programming-how-and-why-does-it-work-3fd8849ed73d
// local_max[i] = max(nums[i], nums[i] + local_max[i - 1])
// local_maximum at index i is the maximum bewteen nums[i] & the sum of nums[i] and local_maximum at index i-1.

// Thus the maximum subarray problem can be solved by
// solving these sub-problems of
// finding local_maximums recursively.
// Also, note that local_maximum[0] would be nums[0] itself.
