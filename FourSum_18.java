package LeetCode;

import java.util.*;

public class FourSum_18 {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums == null || nums.length < 4) return result;
        Arrays.sort(nums);
        
        // for the overflow case:
        // nums:   1 000 000 000 * 4
        // target:  -294 967 296
        if (nums[0] > 0 && target < 0) return result;
        
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int leftPointer = j + 1;
                int rightPointer = nums.length - 1;
                
                while (leftPointer < rightPointer) {
                    long totalSum = nums[i] + nums[j] + nums[leftPointer] + nums[rightPointer];
                    if (totalSum == (long) target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[leftPointer], nums[rightPointer]));
                        
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
    
    
    public static List<List<Integer>> fourSum_I(int[] nums, int target) {
        Arrays.sort(nums);
        return kSum(nums, 0, 4, target);
    }
    
    private static List<List<Integer>> kSum(int[] nums, int start, int k, int target) {
        int length = nums.length;
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (k == 2) { //two pointers from left and right
            int left = start;
            int right = length - 1;
            
            while (left < right) {
                long tempSum = nums[left] + nums[right];
                if (tempSum == target) {
                    result.add(Arrays.asList(nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    left++;
                    right--;
                } else if (tempSum < target) { //move left
                    left++;
                } else { //move right
                    right--;
                }
            }
        } else {
            for (int i = start; i < length - (k - 1); i++) {
                if (i > start && nums[i] == nums[i - 1]) continue;
                List<List<Integer>> tempKSum = kSum(nums, i + 1, k - 1, target - nums[i]);
                for (List<Integer> t : tempKSum) {
                    t.add(0, nums[i]);
                }
                result.addAll(tempKSum);
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
        System.out.println(fourSum(new int[]{1000000000, 1000000000, 1000000000, 1000000000}, -294967296));
        System.out.println(4 * 1000000000);
    }
}
