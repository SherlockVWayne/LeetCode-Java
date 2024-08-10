package LeetCode;

import java.util.*;

public class RankTeamsByVotes_1366 {
    // O(26 n+ (26^2 * log26)), Sort by high rank vote to low rank vote
    public static String rankTeams(String[] votes) {
        Map<Character, int[]> map = new HashMap<>();
        int votedCounts = votes[0].length();
        for (String vote : votes) {
            for (int i = 0; i < votedCounts; i++) {
                char c = vote.charAt(i);
                map.putIfAbsent(c, new int[votedCounts]);
                map.get(c)[i]++;
            }
        }
        
        List<Character> list = new ArrayList<>(map.keySet());
        Collections.sort(list, (a, b) -> {
            for (int i = 0; i < votedCounts; i++) {
                if (map.get(a)[i] != map.get(b)[i]) {
                    return map.get(b)[i] - map.get(a)[i];
                }
            }
            return a - b;
        });
        
        StringBuilder sb = new StringBuilder();
        for (char c : list) {
            sb.append(c);
        }
        return sb.toString();
    }
    
    public static void main(String[] args) {
        System.out.println(rankTeams(new String[]{"ABC", "ACB", "ABC", "ACB", "ACB"}));
    }
}
