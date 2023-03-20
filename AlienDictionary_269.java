package LeetCode;

import java.util.*;

public class AlienDictionary_269 {
  public static String alienOrder(String[] words) {
    HashMap<Character, ArrayList<Character>> adjList = new HashMap<>();
    HashMap<Character, Integer> inDegree = new HashMap<>();
    Queue<Character> queue = new LinkedList<>();
    StringBuilder sb = new StringBuilder();
    
    for (String word : words) {
      for (int i = 0; i < word.length(); i++) {
        char c = word.charAt(i);
        if (!adjList.containsKey(c)) {
          adjList.put(c, new ArrayList<>());
          inDegree.put(c, 0);
        }
      }
    }
    // adjList:
    //    key: all distinct chars
    //    value: new ArrayList<Character>()
    // inDegree:
    //    key: all distinct chars
    //    value: 0
    
    for (int i = 0; i < words.length - 1; i++) {
      String word1 = words[i];
      String word2 = words[i + 1];
      int j = 0;
      while (j < word1.length() && j < word2.length() && word1.charAt(j) == word2.charAt(j)) {
        j++;
      }
      if (j != word1.length() && j != word2.length()) {
        char c1 = word1.charAt(j);
        char c2 = word2.charAt(j);
        adjList.get(c1).add(c2);
        inDegree.merge(c2, 1, Integer::sum);
      } else {
        if (word1.length() > word2.length()) {
          return "";
        }
      }
    }
    
    for (char key : inDegree.keySet()) {
      if (inDegree.get(key) == 0) {
        queue.add(key);
      }
    }
    // add the first char into queue
    
    while (!queue.isEmpty()) {
      char c = queue.remove();
      sb.append(c);
      for (char adj : adjList.get(c)) {
        inDegree.merge(adj, -1, Integer::sum);
        if (inDegree.get(adj) == 0) {
          queue.add(adj);
        }
      }
    }
    
    String ordering = sb.toString();
    if (ordering.length() != adjList.size()) {
      return "";
    }
    
    return ordering;
  }
  
  public static void main(String[] args) {
    System.out.println(alienOrder(new String[]{"wrt", "wrf", "er", "ett", "rftt"}));
  }
}
