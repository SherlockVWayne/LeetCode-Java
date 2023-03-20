package LeetCode;

import java.util.*;

public class TrappingRainWater_42 {
    public static int trap(int[] height) {
        int leftHeightIndex = 0;
        int rightHeightIndex = height.length - 1;

        int leftHeightMax = 0;
        int rightHeightMax = 0;
        int water = 0;

        while (leftHeightIndex < rightHeightIndex) {
            // update
            if (height[leftHeightIndex] > leftHeightMax) {
                leftHeightMax = height[leftHeightIndex];
            }
            if (height[rightHeightIndex] > rightHeightMax) {
                rightHeightMax = height[rightHeightIndex];
            }

            // compute
            if (leftHeightMax < rightHeightMax) { // consider the min
                water += (leftHeightMax - height[leftHeightIndex]);
                // leftHeightMax >= height[leftHeightIndex]
                leftHeightIndex++;
            } else {
                water += (rightHeightMax - height[rightHeightIndex]);
                rightHeightIndex--;
            }
        }

        return water;
    }

    public static void main(String[] args) {
        int[] height = new int[]{2, 1, 3, 1, 4};
//        System.out.println(trap(height));
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 7);
        map.put(1, map.getOrDefault(2, 10));
        System.out.println(map.get(1));
        System.out.println(map.get(2));
    }
}
