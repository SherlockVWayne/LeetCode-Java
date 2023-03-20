package LeetCode;

import java.util.*;

public class ShortestWordDistance_II_244 {
    private HashMap<String, LinkedList<Integer>> map;
    
    public ShortestWordDistance_II_244(String[] words) {
        this.map = new HashMap<String, LinkedList<Integer>>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (!this.map.containsKey(word)) {
                map.put(word, new LinkedList<Integer>());
            }
            this.map.get(word).add(i);
        }
    }
    
    public int shortest(String word1, String word2) {
        int shortest = Integer.MAX_VALUE;
        LinkedList<Integer> indices1 = this.map.get(word1);
        LinkedList<Integer> indices2 = this.map.get(word2);
        int index1 = 0;
        int index2 = 0;
        while (index1 < indices1.size() && index2 < indices2.size()) {
            int w1 = indices1.get(index1);
            int w2 = indices2.get(index2);
            shortest = Math.min(shortest, Math.abs(w1 - w2));
            if (w1 < w2) {
                index1++;
            } else {
                index2++;
            }
        }
        return shortest;
    }
}
