package LeetCode;

import java.util.*;

public class ThreeSum_15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int tmp = nums[left] + nums[right];
                if (tmp + nums[i] == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                } else if (tmp + nums[i] < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }
}
