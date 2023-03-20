package LeetCode;

import java.util.*;

public class Amazon_OA_KConsistencyScore {
    public static int getKConsistency(int[] stockPrices, int k) {
        if (stockPrices == null || stockPrices.length == 0) return -1;
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        int result = 0;
        for (int i = 0; i < stockPrices.length; i++) {
            int stockPrice = stockPrices[i];
            map.putIfAbsent(stockPrice, new ArrayList<>());
            map.get(stockPrice).add(i);
        }

        for (List<Integer> list : map.values()) {
            int currentLongest = 0;
            int n = list.size();
            if (n == 1) continue;

            int deleted = list.get(1) - list.get(0) - 1;
            int left = 0;
            int right = 1;

            while (left < n && right < n) {
                currentLongest = Math.max(right - left + 1, currentLongest);
                while (deleted > k) {
                    deleted -= (list.get(left) - list.get(left - 1) - 1);
                    left++;
                }
                right++;
                if (right < n) {
                    deleted += (list.get(right) - list.get(right - 1) - 1);
                }
                result = Math.max(currentLongest, result);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] array1 = new int[]{1, 1, 2, 1, 2, 1};
        int[] array2 = new int[]{7, 5, 7, 7, 1, 1, 7, 7};
        int k1 = 3;
        int k2 = 3;
//        System.out.println(getKConsistency(array1, k1));
//        System.out.println(getKConsistency(array2, k2));

        Integer[] arr = {3, 4, 5, 2, 1, 7, 0};
        int k = 3;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> (b - a));

        for (Integer i : arr) {
            pq.offer(i);
        }
        System.out.println(pq);
        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
            System.out.println(pq);
        }

        for (Integer i : arr) {
            pq.offer(i);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        System.out.println(pq);
        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }
}
