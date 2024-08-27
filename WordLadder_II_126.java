package LeetCode;

import java.util.*;

public class WordLadder_II_126 {
    
    /**
     * High level design: BFS + DFS
     * Step 1: use BFS to build graph (adjacency list of each word), as well as calculating distance from beginWord to
     * each node in the graph (should store minimum distance)
     * Step 2: use DFS to traverse and record path from beginWord to endWord with shortest path. We can use distance map
     * to control every next word.
     */
    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        if (wordList.size() == 0) {
            return new ArrayList<>();
        }
        
        /**
         * @param result: result list to store final return list
         * @param graphMap: adjacency list of key - store all neighbors of each word (neighbor means all words in dictionary
         *             that only has one character difference with key)
         * @param distanceMap: distanceMap between beginWord and current key word, used for tracing path when we do DFS
         * @param wordSet: word dictionary, efficient for searching purpose
         * */
        List<List<String>> result = new ArrayList<>();
        Map<String, Set<String>> graphMap = new HashMap<>();
        Map<String, Integer> distanceMap = new HashMap<>();
        Set<String> wordSet = new HashSet<>(wordList);
        
        bfs(beginWord, endWord, wordSet, graphMap, distanceMap);
        dfs(result, graphMap, distanceMap, endWord, beginWord, new ArrayList<>(Arrays.asList(beginWord)));
        return result;
    }
    
    // step 1
    public static void bfs(String beginWord, String endWord, Set<String> wordSet, Map<String, Set<String>> graph, Map<String, Integer> distanceMap) {
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        distanceMap.put(beginWord, 0);
        
        while (!queue.isEmpty()) {
            boolean reachEnd = false;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String curWord = queue.poll();
            
            /* try all possible substitution (26 characters) in every position of current word, if newWord exists in dictionary,
               we add it to the adjacency list of curWord */
                for (int j = 0; j < curWord.length(); j++) {
                    char[] curWordArr = curWord.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) {
                        curWordArr[j] = c;
                        String newWord = new String(curWordArr);
                        if (wordSet.contains(newWord)) {
                            graph.putIfAbsent(curWord, new HashSet<>());
                            graph.get(curWord).add(newWord);
                        }
                    }
                }
                
                // traverse all neighbors of current word, update distanceMap map and queue for next ladder (level)
                // WARNING: DO NOT USE visited set, since it is hard to deal with end word if endWord is visited
                for (String neighbor : graph.get(curWord)) {
                    if (!distanceMap.containsKey(neighbor)) {
                        distanceMap.put(neighbor, distanceMap.get(curWord) + 1);
                        if (neighbor.equals(endWord)) {
                            reachEnd = true;
                        } else {
                            queue.offer(neighbor);
                        }
                    }
                }
                if (reachEnd) {
                    break;
                }
            }
        }
    }
    
    // step 2
    public static void dfs(List<List<String>> result, Map<String, Set<String>> graph, Map<String, Integer> distance,
                           String endWord, String curWord, List<String> tempList) {
        if (curWord.equals(endWord)) {
            result.add(new ArrayList<>(tempList));
            return;
        }
        
        for (String nextWord : graph.get(curWord)) {
            // only if next node is on the minimum path to the endWord, we can traverse it
            if (distance.get(nextWord) == distance.get(curWord) + 1) {
                tempList.add(nextWord);
                dfs(result, graph, distance, endWord, nextWord, tempList);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
    
    public static void main(String[] args) {
//        List<List<String>> result = findLadders("hit", "cog", new ArrayList<String>(Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")));
//        for (List<String> list : result) {
//            Print.printStringList(list);
//        }
        
        System.out.println(new WordLadder_II_126().findLadders_II("hit", "cog", new ArrayList<>(Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"))));
    }
    
    public List<List<String>> findLadders_II(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordDict = new HashSet<>(wordList);
        List<List<String>> allPaths = new ArrayList<>();
        if (!wordDict.contains(endWord)) {
            return allPaths;
        }
        
        // Create a map to store the path from start to each node
        Map<String, List<String>> map = new HashMap<>();
        
        // Use a set to store the words of current level
        Set<String> currentLevel = new HashSet<>();
        
        // BFS to construct the path graph
        boolean found = false;
        currentLevel.add(beginWord);
        
        while (!currentLevel.isEmpty() && !found) {
            wordDict.removeAll(currentLevel); // Remove the used word in wordDict
            Set<String> nextLevel = new HashSet<>();
            for (String currentWord : currentLevel) {
                List<String> nextWords = getNextLadder(currentWord, wordDict);
                for (String nextWord : nextWords) {
                    if (nextWord.equals(endWord))
                        found = true;
                    map.putIfAbsent(nextWord, new ArrayList<>());
                    map.get(nextWord).add(currentWord);
                    nextLevel.add(nextWord);
                }
            }
            currentLevel = nextLevel;
        }
        
        // Backtrack to construct paths
        if (found) {
            backtrack(endWord, beginWord, map, new ArrayList<>(), allPaths);
        }
        
        return allPaths;
    }
    
    private List<String> getNextLadder(String word, Set<String> wordDict) {
        List<String> listOfNextLadder = new ArrayList<>();
        char[] charArray = word.toCharArray();
        
        for (int i = 0; i < word.length(); i++) {
            char originalChar = charArray[i];
            for (int c = 'a'; c <= 'z'; c++) {
                charArray[i] = (char) c;
                String newWord = new String(charArray);
                if (wordDict.contains(newWord)) {
                    listOfNextLadder.add(newWord);
                }
            }
            charArray[i] = (char) originalChar;
        }
        return listOfNextLadder;
    }
    
    private void backtrack(String currWord, String beginWord, Map<String, List<String>> map, List<String> currPath, List<List<String>> allPaths) {
        currPath.add(0, currWord);
        if (currWord.equals(beginWord)) {
            allPaths.add(new ArrayList<>(currPath));
            currPath.remove(0);
            return;
        }
        for (String next : map.get(currWord)) {
            backtrack(next, beginWord, map, currPath, allPaths);
        }
        currPath.remove(0);
    }
}
