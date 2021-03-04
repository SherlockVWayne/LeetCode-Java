package LeetCode;

import java.util.HashSet;

public class UniqueMorseCodeWords_804 {
    public int uniqueMorseRepresentations(String[] words) {
        String[] MORSE = new String[]{".-","-...","-.-.","-..",".","..-.","--.",
                "....","..",".---","-.-",".-..","--","-.",
                "---",".--.","--.-",".-.","...","-","..-",
                "...-",".--","-..-","-.--","--.."};

        HashSet<String> uniqueCode = new HashSet();

        for (String word : words) {
            StringBuilder transformation = new StringBuilder();

            for (char c : word.toCharArray()) {
                transformation.append(MORSE[c - 'a']);
            }

            uniqueCode.add(transformation.toString());
        }

        return uniqueCode.size();
    }
}
