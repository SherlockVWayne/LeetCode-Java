package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class LoggerRateLimiter_359 {
    // HashMap
    // TC: O(1)
    // SC: O(n)
    class Logger {
        private Map<String, Integer> map;
        
        public Logger() {
            this.map = new HashMap<>();
        }
        
        public boolean shouldPrintMessage(int timestamp, String message) {
            if (timestamp < map.getOrDefault(message, 0)) {
                return false;
            }
            map.put(message, timestamp + 10);
            return true;
        }
    }
    
    // 2 Sets
    // TC: O(1)
    // SC: O(m) where m is the maximum number of unique message that will be received in a 20 second period.
    class Logger_II {
        
        private Map<String, Integer> mapOld = new HashMap<>();
        private Map<String, Integer> mapNew = new HashMap<>();
        private int timeNew = Integer.MIN_VALUE;
        
        public boolean shouldPrintMessage(int timestamp, String message) {
            if (timestamp >= timeNew + 20) {
                mapOld.clear();
                mapNew.clear();
                timeNew = timestamp;
            } else if (timestamp >= timeNew + 10) {
                Map<String, Integer> temp = mapOld;
                mapOld = mapNew;
                mapNew = temp;
                mapNew.clear();
                timeNew = timestamp;
            }
            
            if (mapNew.containsKey(message)) {
                return false;
            }
            
            Integer oldTimestamp = mapOld.get(message);
            if (oldTimestamp != null && timestamp < oldTimestamp + 10) {
                return false;
            }
            
            mapNew.put(message, timestamp);
            return true;
        }
    }
}
