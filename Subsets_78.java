package LeetCode;

import java.util.*;

public class Subsets_78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) return result;
        List<Integer> subset = new ArrayList<Integer>();
        generateSubset(nums, 0, result, subset);
        return result;
    }
    
    public void generateSubset(int[] nums, int p, List<List<Integer>> result, List<Integer> subset) {
        result.add(new ArrayList<Integer>(subset));
        for (int i = p; i < nums.length; i++) {
            subset.add(nums[i]);
            generateSubset(nums, i + 1, result, subset);
            subset.remove(subset.size() - 1);
        }
    }
    
    public static List<List<Integer>> subsets_II(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) return result;
        result.add(new ArrayList<Integer>());
        
        for (int i = 0; i < nums.length; i++) {
            int n = result.size();
            for (int j = 0; j < n; j++) {
                result.add(new ArrayList<Integer>(result.get(j)));
                result.get(result.size() - 1).add(nums[i]);
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
        List<List<Integer>> result = subsets_II(new int[]{1, 2, 3, 4});
        for (List<Integer> list : result) {
            Print.printIntList(list);
        }
    }
}
