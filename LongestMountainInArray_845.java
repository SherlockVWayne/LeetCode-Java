package LeetCode;

public class LongestMountainInArray_845 {
    public static int longestMountain(int[] arr) {
        int result = 0;
        int[] downToRight = new int[arr.length];
        int[] upToLeft = new int[arr.length];
        
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] > arr[i + 1]) {
                downToRight[i] = downToRight[i + 1] + 1;
            }
        }
        
        for (int i = 0; i < arr.length; i++) {
            if (i > 0 && arr[i] > arr[i - 1]) {
                upToLeft[i] = upToLeft[i - 1] + 1;
            }
            
            if (downToRight[i] > 0 && upToLeft[i] > 0) {
                result = Math.max(downToRight[i] + upToLeft[i] + 1, result);
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        System.out.println(longestMountain(new int[]{2, 1, 4, 7, 3, 2, 5}));
    }
}
//Intuition:
//We have already many 2-pass or 3-pass problems, like 821. Shortest Distance to a Character.
//They have almost the same idea.
//One forward pass and one backward pass.
//Maybe another pass to get the final result, or you can merge it in one previous pass.
//
//Explanation:
//In this problem, we take one forward pass to count up hill length (to every point).
//We take another backward pass to count down hill length (from every point).
//Finally a pass to find max(up[i] + down[i] + 1) where up[i] and down[i] should be positives.
//
//Time Complexity:
//O(N)