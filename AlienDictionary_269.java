package LeetCode;

import java.util.*;

public class AlienDictionary_269 {
    public static String alienOrder(String[] words) {
        HashMap<Character, ArrayList<Character>> adjListMap = new HashMap<>();
        HashMap<Character, Integer> inDegreeMap = new HashMap<>();
        
        // initialize data structure
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (!adjListMap.containsKey(c)) {
                    adjListMap.put(c, new ArrayList<>());
                    inDegreeMap.put(c, 0);
                }
            }
        }
        // adjListMap:
        //    key: all distinct chars
        //    value: new ArrayList<Character>()
        // inDegreeMap:
        //    key: all distinct chars
        //    value: 0
        
        // build graph
        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];
            int j = 0;
            while (j < word1.length() && j < word2.length() && word1.charAt(j) == word2.charAt(j)) {
                j++;
            }
            // starting from charAt(j), word1 and word2 are different
            if (j != word1.length() && j != word2.length()) {
                char c1 = word1.charAt(j);
                char c2 = word2.charAt(j);
                adjListMap.get(c1).add(c2);
                inDegreeMap.put(c2, inDegreeMap.get(c2) + 1);
            } else {
                if (word1.length() > word2.length()) {
                    return "";
                }
            }
        }
        
        LinkedList<Character> queue = new LinkedList<>();
        for (char key : inDegreeMap.keySet()) {
            if (inDegreeMap.get(key) == 0) {
                queue.offerLast(key);
            }
        }
        // add the first char into queue
        
        
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            char c = queue.pollFirst();
            sb.append(c);
            for (char adj : adjListMap.get(c)) {
                inDegreeMap.put(adj, inDegreeMap.get(adj) - 1);
                if (inDegreeMap.get(adj) == 0) {
                    queue.offerLast(adj);
                }
            }
        }
        
        String ordering = sb.toString();
        if (ordering.length() != adjListMap.size()) {
            return "";
        }
        
        return ordering;
    }
    
    public static void main(String[] args) {
        System.out.println(alienOrder(new String[]{"wrt", "wrf", "er", "ett", "rftt"}));
    }
}
