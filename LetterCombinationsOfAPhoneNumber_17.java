package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber_17 {
    private String[] digitsMap = new String[]{
        "0", "1", "abc", "def", "ghi", "jkl", "mno",
        "pqrs", "tuv", "wxyz"
    };
    
    public static void main(String[] args) {
        Print.printStringList(new LetterCombinationsOfAPhoneNumber_17().letterCombinations_II("23"));
    }
    
    public List<String> letterCombinations(String digits) {
        LinkedList<String> output = new LinkedList();
        if (digits.length() == 0) return output;
        output.add("");
        
        String[] charMap = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        
        for (int i = 0; i < digits.length(); i++) {
            int index = Character.getNumericValue(digits.charAt(i));
            while (output.peek().length() == i) {
                String permutation = output.remove();
                for (char c : charMap[index].toCharArray()) {
                    output.add(permutation + c);
                }
            }
        }
        return output;
    }
    
    
    public List<String> letterCombinations_II(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }
        
        LinkedList<String> result = new LinkedList<>();
        result.add("");
        
        for (int i = 0; i < digits.length(); i++) {
            int digit = Character.getNumericValue(digits.charAt(i));
            while (result.peek().length() == i) {
                String s = result.remove();
                for (char c : digitsMap[digit].toCharArray()) {
                    result.add(s + c);
                }
            }
            
        }
        return result;
    }
}
