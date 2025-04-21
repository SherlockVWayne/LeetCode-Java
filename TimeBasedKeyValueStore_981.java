package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Data {
    String value;
    int timestamp;
    
    Data(String value, int timestamp) {
        this.value = value;
        this.timestamp = timestamp;
    }
}

public class TimeBasedKeyValueStore_981 {
    
    
    class TimeMap {
        
        /**
         * Initialize your data structure here.
         */
        Map<String, List<Data>> map;
        
        public TimeMap() {
            map = new HashMap<String, List<Data>>();
        }
        
        public void set(String key, String value, int timestamp) {
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<Data>());
            }
            map.get(key).add(new Data(value, timestamp));
        }
        
        public String get(String key, int timestamp) {
            if (!map.containsKey(key)) return "";
            return binarySearch(map.get(key), timestamp);
        }
        
        private String binarySearch(List<Data> list, int timestamp) {
            int left = 0;
            int right = list.size() - 1;
            while (left < right) {
                int middle = (left + right) >> 1;
                if (list.get(middle).timestamp == timestamp) {
                    return list.get(middle).value;
                } else if (list.get(middle).timestamp < timestamp) {
                    if (list.get(middle + 1).timestamp > timestamp) {
                        return list.get(middle).value;
                    }
                    left = middle + 1;
                } else {
                    right = middle - 1;
                }
            }
            return list.get(left).timestamp <= timestamp ? list.get(left).value : "";
        }
    }
}