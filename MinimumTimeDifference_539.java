package LeetCode;

import java.util.List;

public class MinimumTimeDifference_539 {
    public int findMinDifference(List<String> timePoints) {
        boolean[] timeSeen = new boolean[24 * 60]; // 1440 combinations

        for (String time : timePoints) {
            String[] timeSplit = time.split(":");
            int hour = Integer.parseInt(timeSplit[0]);
            int minute = Integer.parseInt(timeSplit[1]);
            if (timeSeen[(hour * 60) + minute]) return 0;
            timeSeen[(hour * 60) + minute] = true;
        }

        Integer firstTimeSeen = null;
        Integer prevTimeSeen = null;
        Integer minimumDifference = Integer.MAX_VALUE;

        for (int i = 0; i < timeSeen.length; i ++) {
            if (timeSeen[i]) {
                if (firstTimeSeen == null) {
                    firstTimeSeen = i;
                    prevTimeSeen = i;
                } else {
                    minimumDifference = Math.min(minimumDifference, Math.min(i - prevTimeSeen, 1440 - i + prevTimeSeen));
                    prevTimeSeen = i;
                }
            }
        }

        minimumDifference = Math.min(minimumDifference, Math.min(prevTimeSeen - firstTimeSeen, 1440 - prevTimeSeen + firstTimeSeen));

        return minimumDifference;
    }
}
