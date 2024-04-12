package LeetCode;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class CountTheNumberOfKBigIndices_2519 {
    public static int kBigIndices(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        int result = 0;
        Queue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        boolean[] prefix = new boolean[length]; // records backwards k validity
        
        /**
         * This for block marks if there're k nums smaller than the current pos backwards(<-)
         *   [2,  3,  6,  5,  2,  3]
         *    F   F   T   T   F   T
         */
        for (int i = 0; i < length; i++) {
            if (pq.size() == k &&
                pq.peek() < nums[i]) {
                prefix[i] = true;
            }
            pq.add(nums[i]);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        
        pq.clear();
        
        /**
         * This for block marks if there're k nums smaller than the current pos inwards(->)
         *   [2,  3,  6,  5,  2,  3]
         *    F   F   T   T   F   F
         */
        for (int i = length - 1; i >= 0; i--) {
            if (pq.size() == k &&
                pq.peek() < nums[i] &&
                prefix[i] == true) {
                result++;
            }
            pq.add(nums[i]);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        
        return result;
    }
//    Time O(Nlogk)
//    Space O(N)
    
    public static void main(String[] args) {
        System.out.println(kBigIndices(new int[]{2, 3, 6, 5, 2, 3}, 2));
    }
}
