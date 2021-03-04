package LeetCode;

public class ContainerWithMostWater_11 {
    public int maxArea(int[] height) {
        if (height == null || height.length == 0) return -1;
        int maxArea = 0;
        int aPointer = 0;
        int bPointer = height.length - 1;

        while (aPointer < bPointer) {
            if (height[aPointer] < height[bPointer]) {
                maxArea = Math.max(maxArea, height[aPointer] * (bPointer - aPointer));
                aPointer += 1;
            } else {
                maxArea = Math.max(maxArea, height[bPointer] * (bPointer - aPointer));
                bPointer -= 1;
            }
        }
        return maxArea;
    }
}
