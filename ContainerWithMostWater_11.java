package LeetCode;

public class ContainerWithMostWater_11 {
    public int maxArea(int[] height) {
        if (height == null || height.length == 0) return -1;
        int maxWater = 0;
        int aPointer = 0;
        int bPointer = height.length - 1;
        
        while (aPointer < bPointer) {
            if (height[aPointer] < height[bPointer]) {
                maxWater = Math.max(maxWater, height[aPointer] * (bPointer - aPointer));
                aPointer += 1;
            } else {
                maxWater = Math.max(maxWater, height[bPointer] * (bPointer - aPointer));
                bPointer -= 1;
            }
        }
        return maxWater;
    }
}
