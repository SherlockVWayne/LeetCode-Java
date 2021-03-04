package LeetCode;

import java.util.HashMap;

public class SubarraySumEqualsK_560 {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> arraySum = new HashMap();
        arraySum.put(0, 1);

        int sum = 0;
        int result = 0;

        for (int i = 0; i < nums.length; i ++) {
            sum += nums[i];

            if (arraySum.containsKey(sum - k)) {
                result += arraySum.get(sum - k);
            }

            arraySum.put(sum, arraySum.getOrDefault(sum, 0) + 1);
        }

        return result;
    }
}
