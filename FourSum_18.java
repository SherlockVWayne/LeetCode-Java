package LeetCode;

import java.util.*;

public class FourSum_18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums == null || nums.length < 4) return result;
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int leftPointer = j + 1;
                int rightPointer = nums.length - 1;

                while (leftPointer < rightPointer) {
                    int totalSum = nums[i] + nums[j] + nums[leftPointer] + nums[rightPointer];

                    if (totalSum == target) {
                        List<Integer> temp = new ArrayList<Integer>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[leftPointer]);
                        temp.add(nums[rightPointer]);
                        result.add(temp);

                        int left = nums[leftPointer];
                        int right = nums[rightPointer];

                        while (leftPointer < rightPointer && nums[leftPointer] == left) {
                            leftPointer++;
                        }

                        while (rightPointer > leftPointer && nums[rightPointer] == right) {
                            rightPointer--;
                        }
                    } else if (totalSum < target) {
                        leftPointer++;
                    } else {
                        rightPointer--;
                    }
                }

                while (j + 1 < nums.length && nums[j + 1] == nums[j]) {
                    j++;
                }
            }
            while (i + 1 < nums.length && nums[i + 1] == nums[i]) {
                i++;
            }
        }
        return result;
    }
}
