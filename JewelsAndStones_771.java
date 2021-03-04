package LeetCode;

public class JewelsAndStones_771 {
    public int numJewelsInStones(String jewels, String stones) {
        int numJewels = 0;

        for (int i = 0; i < stones.length(); i ++) {
            if (jewels.indexOf(stones.charAt(i)) > -1) {
                numJewels += 1;
            }
        }
        return numJewels;
    }
}
