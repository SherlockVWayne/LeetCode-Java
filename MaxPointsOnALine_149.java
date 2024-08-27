package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class MaxPointsOnALine_149 {
    public int maxPoints(int[][] points) {
        int max = 1;
        Map<Double, Integer> map = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            int dupNodesCount = 0;
            map.clear();
            for (int j = i + 1; j < points.length; j++) {
                int dx = points[j][0] - points[i][0];
                int dy = points[j][1] - points[i][1];
                if (dx == 0 && dy == 0) {
                    dupNodesCount++;
                } else if (dx == 0) {
                    if (map.get(0.0) == null) {
                        map.put(0.0, 2);
                    } else {
                        map.put(0.0, map.get(0.0) + 1);
                    }
                } else if (dy == 0) {
                    if (map.get(Double.MAX_VALUE) == null) {
                        map.put(Double.MAX_VALUE, 2);
                    } else {
                        map.put(Double.MAX_VALUE, map.get(Double.MAX_VALUE) + 1);
                    }
                } else {
                    
                    double slope = (double) dy / dx;
                    
                    if (map.get(slope) == null) {
                        map.put(slope, 2);
                    } else {
                        map.put(slope, map.get(slope) + 1);
                    }
                }
            }
            
            for (Map.Entry<Double, Integer> entry : map.entrySet()) {
                max = Math.max(max, entry.getValue() + dupNodesCount);
            }
        }
        return max;
    }
}
