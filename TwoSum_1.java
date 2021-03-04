package LeetCode;

import java.util.*;

public class TwoSum_1 {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i ++) {
            for (int j = i + 1; j < nums.length; j ++) {
                if (nums[j] == target - nums[i]) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("No match found");
    }

    public int[] twoSum_II(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i ++) {
            if (map.containsKey(target - nums[i])) {
                return new int[] {map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }

        throw new IllegalArgumentException("No match found");
    }

    public int[] twoSum_III(int[] nums, int target) {
        if (nums == null || nums.length <2) {
            return new int[]{0,0};
        }
        int[] res = new int[]{0,0};
        HashMap<Integer, Integer> map = new HashMap<> ();
        for (int i = 0; i< nums.length; i++) {
            if(map.containsKey(target - nums[i])) {
                res[0] = map.get(target - nums[i]);
                res[1] = i;
                break;
            }
            map.put(nums[i],i);
        }
        return res;
    }
}
