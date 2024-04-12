package LeetCode;

import java.util.Arrays;

public class RemoveLetterToEqualizeFrequency_2423 {
    public boolean equalFrequency(String word) {
        int[] counts = new int[26];
        int distinct = 0; // how many distinct chars
        for (char c : word.toCharArray()) {
            if (counts[c - 'a'] == 0) {
                distinct++;
            }
            counts[c - 'a']++;
        }
        Arrays.sort(counts);
        return distinct == 1   // If there's only one distinct letter, removing any letter would still fulfill the requirement.
            // e.g., 1 000000000...
            
            || counts[25] == 1 // If the highest frequency is one , removing this single occurrence will balance the frequencies.
            // e.g., 111111 0000...
            
            || (counts[25] - counts[24] == 1 && counts[26 - distinct] == counts[24])
            // If the highest frequency can be decreased by one to match the second-highest (counts[25] - counts[24] == 1)
            // and all frequencies of less frequent letters match the second-highest (counts[24] == counts[26 - distinct]),
            // removing one instance of the most frequent letter will equalize the frequencies.
            // e.g., 9 88888 0000000...
            
            || (counts[26 - distinct] == 1 && counts[25] == counts[27 - distinct])
            // If the least frequent non-zero letter can be removed (counts[26 - distinct] == 1)
            // and the most frequent letter has the same frequency as all others when the least frequent is discounted (counts[25] == counts[27 - distinct]),
            // then removal of this single-occurrence letter would lead to equal frequencies.
            // e.g., 55555 1 00000...
            ;
    }
}
