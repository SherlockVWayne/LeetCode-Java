package LeetCode;

public class NumberOfShipsInARectangle_1274 {
    class Sea {
        public boolean hasShips(int[] topRight, int[] bottomLeft) {
            return false;
        }
    }
    
    public int countShips(Sea sea, int[] topRight, int[] bottomLeft) {
        int result = 0;
        //only continue with rectangles that are valid and have ships
        if (topRight[0] >= bottomLeft[0]
            && topRight[1] >= bottomLeft[1]
            && sea.hasShips(topRight, bottomLeft)) {
            
            // this is rect of 1 point only - return 1
            // return 1 because this rec CONTAINS ships (boundary check)
            if (topRight[0] == bottomLeft[0]
                && topRight[1] == bottomLeft[1]) {
                return 1;
            }
            
            //center point
            int newX = (bottomLeft[0] + topRight[0]) / 2;
            int newY = (bottomLeft[1] + topRight[1]) / 2;
            
            //split into 4 squares
            //up-right
            result += countShips(sea, topRight, new int[]{newX + 1, newY + 1});
            //up-left
            result += countShips(sea,
                new int[]{newX, topRight[1]},
                new int[]{bottomLeft[0], newY + 1});
            
            //bottom-left
            result += countShips(sea, new int[]{newX, newY}, bottomLeft);
            //bottom-right
            result += countShips(sea,
                new int[]{topRight[0], newY},
                new int[]{newX + 1, bottomLeft[1]});
        }
        return result;
    }
}
// We can check every 1/4 of the rectangle recursively, eleminating every rectangle that doesn't have any ships. Base case if when both points are the same - in this case return 1.
// Time Complexity: O(n) - we can check every cell
// where n is total number of points inside the rectangle
// T(n) = 4 * T(n/4) + O(1)
// Space Complexity: O(logn) - memory required for the call stack.

/**
 * // This is Sea's API interface.
 * // You should not implement it, or speculate about its implementation
 * class Sea {
 * public boolean hasShips(int[] topRight, int[] bottomLeft);
 * }
 */