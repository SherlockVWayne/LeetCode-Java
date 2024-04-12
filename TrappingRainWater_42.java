package LeetCode;

import java.util.*;

public class TrappingRainWater_42 {
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        
        int maxFromLeft = 0;
        int maxFromRight = 0;
        
        int indexFromLeft = 0;
        int indexFromRight = height.length - 1;
        
        int rain = 0;
        
        // From left: rain will only be stored when:
        //   height[curIndex] < maxFromLeft < maxFromRight
        
        // From right: rain will only be stored when:
        //   height[curIndex] < maxFromRight < maxFromLeft
        
        while (indexFromLeft < indexFromRight) {
            // Step I: Update max from both sides
            maxFromLeft = Math.max(maxFromLeft, height[indexFromLeft]);
            maxFromRight = Math.max(maxFromRight, height[indexFromRight]);
            
            // Step II: Check if curIndex can store rain
            // ALWAYS Go to the INNER direction
            if (maxFromLeft < maxFromRight) {
                // maxFromLeft is the boundry
                rain += maxFromLeft - height[indexFromLeft];
                indexFromLeft++;
            } else {
                // maxFromRight is the boundry
                rain += maxFromRight - height[indexFromRight];
                indexFromRight--;
            }
        }
        
        return rain;
    }
    // Time Complexity:  O(n)
    // Space Complexity: O(1)
    
    
    public static int trap_I(int[] height) {
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
