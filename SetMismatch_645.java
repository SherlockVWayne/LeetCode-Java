package LeetCode;

import java.util.*;

public class SetMismatch_645 {
    public int[] findErrorNums(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }
        Arrays.sort(nums);
        Set<Integer> set = new HashSet<>();
        int duplicates = -1;
        int missingNum = -1;
        for (int i = 0; i < nums.length; i++) {
            if (i >= 1 && nums[i] == nums[i - 1]) {
                duplicates = nums[i];
            }
            set.add(nums[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(i + 1)) {
                missingNum = i + 1;
            }
        }
        return new int[]{duplicates, missingNum};
    }
}
