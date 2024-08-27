package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class NumberOfPairsOfStringsWithConcatenationEqualToTarget_2023 {
    public static void main(String[] args) {
        String str1 = "abcdab";
        String str2 = "ab";
        int i = str1.indexOf(str2);
        System.out.println(i);
    }
    
    public int numOfPairs(String[] nums, String target) {
        Map<String, Integer> map = new HashMap<>();
        int result = 0;
        for (String num : nums) {
            if (target.startsWith(num)) {
                String substring = target.substring(num.length());
                if (map.containsKey(substring)) {
                    result += map.get(substring);
                }
            }
            if (target.endsWith(num)) {
                String substring = target.substring(0, target.length() - num.length());
                if (map.containsKey(substring)) {
                    result += map.get(substring);
                }
            }
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return result;
    }
}
