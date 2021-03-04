package LeetCode;

import java.util.*;

public class SubsetsII_90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if (nums == null || nums.length == 0) return result;
        Arrays.sort(nums);

        generateSubset(nums, 0, result, new ArrayList<Integer>());

        return result;
    }

    public void generateSubset(int[] nums, int pointer, List<List<Integer>> result, List<Integer> subset) {
        if (result.contains(subset)) return;
        result.add(new ArrayList<Integer>(subset));

        for (int i = pointer; i < nums.length; i++) {
            subset.add(nums[i]);
            generateSubset(nums, i + 1, result, subset);
            subset.remove(subset.size() - 1);
        }
    }
}
