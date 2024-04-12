package LeetCode;

import java.util.*;

public class WordBreak_139 {
    public static boolean wordBreak(String s, List<String> wordDict) {
        boolean[] isWordBreak = new boolean[s.length() + 1];
        isWordBreak[0] = true;
        
        for (int i = 0; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (!isWordBreak[j]) {
                    continue;
                }
                if (wordDict.contains(s.substring(j, i))) {
                    isWordBreak[i] = true;
                    break;
                }
            }
        }
        
        return isWordBreak[s.length()];
    }
    
    public static void main(String[] args) {
        System.out.println(wordBreak("leetcode", new ArrayList<String>(
            List.of("leet", "code")
        )));
    }
    
    public class TrieNode {
        boolean isWord;
        TrieNode[] c;
        
        public TrieNode() {
            isWord = false;
            c = new TrieNode[128];
        }
    }
    
    public void addWord(TrieNode t, String w) {
        for (int i = 0; i < w.length(); i++) {
            int j = (int) w.charAt(i);
            if (t.c[j] == null) t.c[j] = new TrieNode();
            t = t.c[j];
        }
        t.isWord = true;
    }
    
    public boolean wordBreak_II(String s, List<String> wordDict) {
        TrieNode t = new TrieNode(), cur;
        for (String i : wordDict) addWord(t, i);
        char[] str = s.toCharArray();
        int len = str.length;
        boolean[] f = new boolean[len + 1];
        f[len] = true;
        
        for (int i = len - 1; i >= 0; i--) {
            //System.out.println(str[i]);
            cur = t;
            for (int j = i; cur != null && j < len; j++) {
                cur = cur.c[(int) str[j]];
                if (cur != null && cur.isWord && f[j + 1]) {
                    f[i] = true;
                    break;
                }
            }
        }
        return f[0];
    }
    
}

// https://leetcode.com/problems/word-break/discuss/43790/Java-implementation-using-DP-in-two-ways

// First DP: [length of s][size of dict][avg length of words in dict]
// Second DP: [length of s]^3

// BTW, for this kind of problem, which time complexity is [length of s][size of dict][avg length of words in dict]. We can usually remove [size of dict] by using Tire, remove [avg length of words in dict] by KMP, and what's more, remove both [size of dict] and [avg length of words in dict] by AC-automata. And of course these are all doable for this problem.
// This is just a insight for people who want to think deeper about this problem, hope it can help you :)

