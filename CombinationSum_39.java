package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum_39 {
    public static List<List<Integer>> combinationSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        backtrack(result, new ArrayList<Integer>(), nums, target, 0);
        return result;
    }
    
    private static void backtrack(List<List<Integer>> result, List<Integer> tempResult, int[] nums, int remain, int index) {
        if (remain < 0) {
            return;
        } else if (remain == 0) {
            result.add(new ArrayList<>(tempResult));
            // result.add(tempResult);
            // simply adds a reference to the existing tempResult list.
        } else {
            for (int i = index; i < nums.length; i++) {
                tempResult.add(nums[i]);
                backtrack(result, tempResult, nums, remain - nums[i], i);
                // not i + 1 because we can reuse same elements
                tempResult.remove(tempResult.size() - 1);
            }
        }
    }
    
    public static void main(String[] args) {
        System.out.println(combinationSum(new int[]{2, 3, 6, 7}, 7));
    }
}
