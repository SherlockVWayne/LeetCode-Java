package LeetCode;

public class PoorPigs_458 {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int requiredPigs = 0;
        int maxTestTimesPerPig = minutesToTest / minutesToDie + 1;
        // max time for a pig to test buckets
        // Note that, max time will not be (minutesToTest / minutesToDie)
        // Thinking about all pigs drinking all buckets at last, but no one died immediately
        // so the poison bucket is the last bucket...
        
        while (Math.pow(maxTestTimesPerPig, requiredPigs) < buckets) {
            requiredPigs++;
        }
        return requiredPigs;
    }
}
