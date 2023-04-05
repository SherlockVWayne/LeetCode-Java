package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;

public class DesignHitCounter_362 {
    LinkedList<Integer> queue;
    
    public DesignHitCounter_362() {
        this.queue = new LinkedList<Integer>();
    }
    
    public void hit(int timestamp) {
        this.queue.offerLast(timestamp);
    }
    
    public int getHits(int timestamp) {
        while (!queue.isEmpty() && timestamp - this.queue.peek() >= 300) {
            this.queue.pollFirst();
        }
        return this.queue.size();
    }
    
    ArrayList<Integer> list;
    int start;

//    public HitCounter_II() {
//        this.list = new ArrayList<Integer>();
//        this.start = 0;
//    }
    
    public void hit_II(int timestamp) {
        this.list.add(timestamp);
        while (start < list.size() && list.get(start) <= timestamp - 300) {
            start += 1;
        }
    }
    
    public int getHits_II(int timestamp) {
        while (start < list.size() && list.get(start) <= timestamp - 300) {
            start += 1;
        }
        return list.size() - start;
    }
}
/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */