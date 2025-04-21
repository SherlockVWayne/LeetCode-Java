package LeetCode;

public class MinimumNumberOfTapsToOpenToWaterAGarden_1326 {
    
    public static void main(String[] args) {
        System.out.println(new MinimumNumberOfTapsToOpenToWaterAGarden_1326().minTaps(
            5, new int[]{3, 3, 1, 1, 0, 1}
        ));
    }
    
    public int minTaps(int n, int[] ranges) {
        int[] newRanges = new int[n + 1];
        for (int position = 0; position <= n; position++) {
            if (ranges[position] == 0) continue; // skip when tap cannot cover
            int leftLimit = Math.max(0, position - ranges[position]);
            int rightLimit = Math.min(n, position + ranges[position]);
            newRanges[leftLimit] = Math.max(newRanges[leftLimit], rightLimit);
        }
        
        int lastPosTapCover = 0;
        int tapCount = 0;
        for (int position = 0; position <= n && lastPosTapCover < n; ) {
            int currLastPosTapCover = lastPosTapCover;
            tapCount++;
            while (position <= n && position <= lastPosTapCover) {
                currLastPosTapCover = Math.max(newRanges[position++], currLastPosTapCover);
            }
            if (currLastPosTapCover == lastPosTapCover) return -1;
            lastPosTapCover = currLastPosTapCover;
        }
        return tapCount;
    }
    
}
