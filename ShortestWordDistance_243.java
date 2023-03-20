package LeetCode;

public class ShortestWordDistance_243 {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        int index1 = Integer.MIN_VALUE;
        int index2 = Integer.MIN_VALUE;
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < wordsDict.length; i++) {
            if (wordsDict[i].equals(word1)) {
                index1 = i;
            } else if (wordsDict[i].equals(word2)) {
                index2 = i;
            }
            if (index1 != Integer.MIN_VALUE && index2 != Integer.MIN_VALUE) {
                result = Math.min(result, Math.abs(index1 - index2));
            }
        }
        return result;
    }
}
