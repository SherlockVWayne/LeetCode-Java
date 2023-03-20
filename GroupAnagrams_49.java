package LeetCode;

import java.util.*;

public class GroupAnagrams_49 {
    public List<List<String>> groupAnagrams(String[] strings) {
        if (strings == null || strings.length == 0) return new ArrayList<List<String>>();
        Map<String, List<String>> map = new HashMap<String, List<String>>();

        for (String string : strings) {
            char[] charArray = string.toCharArray();
            Arrays.sort(charArray);
            String stringKey = String.valueOf(charArray);
            if (!map.containsKey(stringKey)) {
                map.put(stringKey, new ArrayList<String>());
            }
            map.get(stringKey).add(string);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
//        System.out.println(String.valueOf("tan"));
//        System.out.println(String.valueOf("nat"));
//
//        char[] arr = "tan".toCharArray();
//        Arrays.sort(arr);
//        System.out.println(arr.toString());
//        System.out.println(String.valueOf(arr));
        String s1 = "laiden";
        String s2 = "laiden";
        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));
    }
}
