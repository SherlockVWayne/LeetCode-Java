package LeetCode;

public class VerifyingAnAlienDictionary_953 {
    public int[] charMap;
    public boolean isAlienSorted(String[] words, String order) {
        charMap = new int[26];
        for (int i = 0; i < order.length(); i ++) {
            charMap[order.charAt(i) - 'a'] = i;
        }

        for (int i = 1; i < words.length; i ++) {
            if (compare(words[i - 1], words[i]) > 0) {
                return false;
            }
        }

        return true;
    }

    public int compare (String word1, String word2) {
        int word1Index = 0;
        int word2Index = 0;

        int charCompareVal = 0;

        while (word1Index < word1.length() && word2Index < word2.length() && charCompareVal == 0) {
            charCompareVal = charMap[word1.charAt(word1Index) - 'a'] - charMap[word2.charAt(word2Index) - 'a'];
            word1Index ++;
            word2Index ++;
        }

        if (charCompareVal == 0) {
            return word1.length() - word2.length();
        } else {
            return charCompareVal;
        }
    }
}
