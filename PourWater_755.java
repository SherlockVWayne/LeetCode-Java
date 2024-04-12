package LeetCode;

public class PourWater_755 {
    public static int[] pourWater(int[] heights, int volume, int k) {
        for (int i = 0; i < volume; i++) {
            int currentIndex = k;
            // I. Move left
            while (currentIndex > 0 &&
                heights[currentIndex] >= heights[currentIndex - 1]) {
                currentIndex--;
            }
            // currentIndex: leftmost pit for this droplet
            
            // II. Move right
            while (currentIndex < heights.length - 1
                && heights[currentIndex] >= heights[currentIndex + 1]) {
                currentIndex++;
            }
            // currentIndex: rightmost pit for this droplet
            // currentIndex is possible that:
            // currentIndex > k
            
            // III. Move left to K
            while (currentIndex > k
                && heights[currentIndex] == heights[currentIndex - 1]) {
                currentIndex--;
            }
            heights[currentIndex]++;
        }
        
        return heights;
    }
    
    public static void main(String[] args) {
        Print.printIntArray(pourWater(new int[]{2, 1, 1, 2, 1, 2, 2}, 4, 3));
    }
}
