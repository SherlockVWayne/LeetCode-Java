package LeetCode;

import java.util.*;

public class ConcatenatedWords_472 {
    public static List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> concatenateWords = new ArrayList<>();
        Set<String> s = new HashSet<>(Arrays.asList(words));
        for (String word : words) {
            if (checkConcatenate(word, s))
                concatenateWords.add(word);
        }
        return concatenateWords;
    }
    
    public static boolean checkConcatenate(String word, Set<String> s) {
        for (int i = 1; i < word.length(); i++) {
            String prefixWord = word.substring(0, i);
            String suffixWord = word.substring(i, word.length());
            if (s.contains(prefixWord) &&
                (s.contains(suffixWord) || checkConcatenate(suffixWord, s))
            )
                return true;
        }
        return false;
    }
//Time complexity: O(n^2*m)
//  where n is the number of words in the input array and m is the average length of the words.
//The checkConcatenate() function is called for each word in the input array, and for each call, it iterates through the word to check for possible concatenation, which takes O(m) time. The find() function of the set data structure takes O(log(n)) time on average. So, the total time complexity of the checkConcatenate() function is O(nmlog(n)). Since this function is called for each word in the input array, the total time complexity of the findAllConcatenatedWordsInADict() function is O(n^2mlog(n)).
//
//Space complexity: O(n*m) //where n is the number of words in the input array and m is the average length of the words.
//The space complexity O(nm), where n is the number of words in the input array and m is the average length of the words. The set data structure is used to store all the words in the input array, which takes O(nm) space.
    
    
    public static List<String> findAllConcatenatedWordsInADict_II(String[] words) {
        //sort the array in asc order of word length, since longer words are formed by shorter words.
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        
        List<String> result = new ArrayList<>();
        
        //list of shorter words
        HashSet<String> preWords = new HashSet<>();
        
        for (int i = 0; i < words.length; i++) {
            //Word Break-I problem.
            if (wordBreak(words[i], preWords)) result.add(words[i]);
            preWords.add(words[i]);
        }
        return result;
    }
    
    private static boolean wordBreak(String s, HashSet<String> preWords) {
        if (preWords.isEmpty()) return false;
        
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && preWords.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
//    Time Complexity: O(total no.of words * (n^3)) where n = avg length of each word.
    
    public static void main(String[] args) {
        System.out.println((findAllConcatenatedWordsInADict_II(new String[]{"cat", "cats", "catsdogcats", "dog", "dogcatsdog", "hippopotamuses", "rat", "ratcatdogcat"})));
    }
}