package LeetCode;

import java.util.*;

public class PermutationsII_47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if (nums == null || nums.length == 0) return result;

        Arrays.sort(nums);
        boolean[] seen = new boolean[nums.length];

        dfs(nums, seen, result, new ArrayList<Integer>());

        return result;
    }

    public void dfs(int[] nums, boolean[] seen, List<List<Integer>> result, List<Integer> list) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<Integer>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (seen[i]) continue;
            if (i > 0 && nums[i - 1] == nums[i] && !seen[i - 1]) continue;
            seen[i] = true;
            list.add(nums[i]);
            dfs(nums, seen, result, list);
            seen[i] = false;
            list.remove(list.size() - 1);
        }
    }
}
