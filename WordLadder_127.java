package LeetCode;

import java.util.*;

public class WordLadder_127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        
        if (!set.contains(endWord)) {
            return 0;
        }
        // To get the shortest path from beginWord to endWord
        // Use BFS to find shortest and implement by queue
        LinkedList<String> queue = new LinkedList<>();
        queue.offerLast(beginWord);
        
        Set<String> visited = new HashSet<>();
        queue.add(beginWord);
        // set will track visited word
        
        int level = 1;
        // At minimum we're going to have starting word in the minimum.
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                String word = queue.pollFirst();
                if (word.equals(endWord)) return level;
                
                for (int charToBeReplacedIndex = 0; charToBeReplacedIndex < word.length(); charToBeReplacedIndex++) {
                    for (int c = 'a'; c <= 'z'; c++) {
                        char[] wordCharArray = word.toCharArray();
                        wordCharArray[charToBeReplacedIndex] = (char) c;
                        
                        String wordWithOneTrans = new String(wordCharArray);
                        if (set.contains(wordWithOneTrans) && // a valid path
                            !visited.contains(wordWithOneTrans)) { // unvisited
                            queue.offerLast(wordWithOneTrans);
                            visited.add(wordWithOneTrans);
                        }
                    }
                }
            }
            
            level++;
        }
        return 0;
    }
}

// https://leetcode.com/problems/word-ladder/solutions/1764371/a-very-highly-detailed-explanation/
// Time Complexity :- BigO(M^2 * N), where M is size of dequeued word & N is size of our word list

// Space Complexity :- BigO(M * N) where M is no. of character that we had in our string & N is the size of our wordList.
