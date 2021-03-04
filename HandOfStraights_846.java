package LeetCode;

import java.util.TreeMap;

public class HandOfStraights_846 {
    public boolean isNStraightHand(int[] hand, int W) {
        TreeMap<Integer, Integer> cardCounts = new TreeMap<>();
        for (int card : hand) {
            if (!cardCounts.containsKey(card)) {
                cardCounts.put(card, 1);
            } else {
                cardCounts.replace(card, cardCounts.get(card) + 1);
            }
        }
        while (cardCounts.size() > 0) {
            int firstCard = cardCounts.firstKey();
            for (int i = firstCard; i < firstCard + W; i ++) {
                if (!cardCounts.containsKey(i)) return false;
                int count = cardCounts.get(i);
                if (count == 1) {
                    cardCounts.remove(i);
                } else {
                    cardCounts.replace(i, cardCounts.get(i) - 1);
                }
            }
        }
        return true;
    }
}
