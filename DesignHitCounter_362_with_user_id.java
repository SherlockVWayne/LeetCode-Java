package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DesignHitCounter_362_with_user_id {
    class HitCounter_with_user_id {
        List<int[]> list;
        
        public HitCounter_with_user_id() {
            this.list = new ArrayList<>();
        }
        
        public void hit(int userId, int timestamp) {
            this.list.add(new int[]{userId, timestamp});
        }
        
        public int getHits(int timestamp) {
            int hits = 0;
            int index = this.list.size() - 1;
            while (index >= 0 && timestamp - this.list.get(index)[1] < 300) {
                index -= 1;
                hits += 1;
            }
            return hits;
        }
        
        public int getHits(int userId, int timestamp) {
            int index = this.list.size() - 1;
            Map<Integer, Integer> map = new HashMap<>();
            while (index >= 0 && timestamp - this.list.get(index)[1] < 300) {
                index -= 1;
                map.put(this.list.get(index)[0], map.getOrDefault(this.list.get(index)[0], 0) + 1);
            }
            if (!map.containsKey(userId)) {
                return 0;
            }
            return map.get(userId);
        }
    }
}
