package LeetCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate_217 {
    
    public boolean containsDuplicate_III(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        Set<Integer> set = new HashSet<Integer>();
        for (int num : nums) {
            set.add(num);
        }
        return set.size() != nums.length;
    }
    
    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        HashSet<Integer> numbers = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (numbers.contains(nums[i])) return true;
            numbers.add(nums[i]);
        }
        return false;
    }
    
    public boolean containsDuplicate_II(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) return true;
        }
        return false;
    }
    
}
