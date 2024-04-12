package LeetCode;

import java.util.*;

public class DesignALeaderboard_1244 {
    
    Map<Integer, Integer> scoreMap; // record scores
    // key: id
    // val: score
    TreeMap<Integer, Integer> sortedScoreMap;
    // key: score (high -> low)
    // val: score frequency
    
    public DesignALeaderboard_1244() {
        scoreMap = new HashMap<>();
        sortedScoreMap = new TreeMap<>(Collections.reverseOrder());
        // elements will be sorted in reverse natural order
        // sorted from highest to lowes
    }
    
    public void addScore(int playerId, int score) {
        if (!scoreMap.containsKey(playerId)) {
            scoreMap.put(playerId, score);
            sortedScoreMap.put(score, sortedScoreMap.getOrDefault(score, 0) + 1);
        } else {
            int preScore = scoreMap.get(playerId);
            sortedScoreMap.put(preScore, sortedScoreMap.get(preScore) - 1);
            if (sortedScoreMap.get(preScore) == 0) {
                sortedScoreMap.remove(preScore);
            }
            int newScore = preScore + score;
            scoreMap.put(playerId, newScore);
            sortedScoreMap.put(newScore, sortedScoreMap.getOrDefault(newScore, 0) + 1);
        }
    }
    
    public int top(int K) {
        int result = 0;
        for (Map.Entry<Integer, Integer> entry : sortedScoreMap.entrySet()) {
            int score = entry.getKey();
            int count = entry.getValue();
            int n = Math.min(count, K);
            result += n * score;
            K -= n;
            if (K == 0) break;
        }
        return result;
    }
    
    public void reset(int playerId) {
        int preScore = scoreMap.get(playerId);
        sortedScoreMap.put(preScore, sortedScoreMap.get(preScore) - 1);
        if (sortedScoreMap.get(preScore) == 0) {
            sortedScoreMap.remove(preScore);
        }
        scoreMap.remove(playerId);
    }
}
// 1.Use HashMap to record the people's score
// 2.Use TreeMap to find the topK in O(klogn) by traverse the treemap
// 3.Reset we can just remove the key from the treemap which is O(log n), same for addScore().
/**
 * Your Leaderboard object will be instantiated and called as such:
 * Leaderboard obj = new Leaderboard();
 * obj.addScore(playerId,score);
 * int param_2 = obj.top(K);
 * obj.reset(playerId);
 */
