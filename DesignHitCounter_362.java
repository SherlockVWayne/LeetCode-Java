package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class DesignHitCounter_362 {
    class HitCounter {
        List<Integer> list;
        
        public HitCounter() {
            this.list = new ArrayList<>();
        }
        
        public void hit(int timestamp) {
            this.list.add(timestamp);
        }
        
        public int getHits(int timestamp) {
            int counts = 0;
            int index = this.list.size() - 1;
            while (index >= 0 && timestamp - list.get(index) < 300) {
                counts += 1;
                index -= 1;
            }
            return counts;
        }
    }
}
