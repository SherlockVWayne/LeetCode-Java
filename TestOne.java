package LeetCode;

import java.util.*;
import java.util.stream.Collectors;

public class TestOne {
    public static int factorial(int num) {
        if (num <= 1) {
            return 1;
        } else {
            return num * factorial(num - 1);
        }
    }
    
    public static int max(int[] array) {
        int result = 0;
        result = Arrays.stream(array).max().getAsInt();
        return result;
    }
    
    public static boolean isAnagram(String str1, String str2) {
        if (str1 == null || str1.length() == 0 || str2 == null || str2.length() == 0) {
            return false;
        }
        
        char[] charSet1 = str1.toCharArray();
        char[] charSet2 = str1.toCharArray();
        Arrays.sort(charSet1);
        Arrays.sort(charSet2);
        
        return Arrays.equals(charSet1, charSet2);
    }
    
    public static String solve(String[] array) {
        if (array == null || array.length == 0) {
            return "";
        }
        Map<String, List<Integer>> map = new HashMap<>();
        int globalMinDistance = Integer.MAX_VALUE;
        String value = "";
        for (int i = 0; i < array.length; i++) {
            String string = array[i];
            if (map.containsKey(string)) {
                if (globalMinDistance > i - map.get(string).get(map.get(string).size() - 1)) {
                    globalMinDistance = i - map.get(string).get(map.get(string).size() - 1);
                    value = string;
                }
            } else {
                map.put(string, new ArrayList<Integer>());
            }
            map.get(string).add(i);
        }
        
        return value + "-" + String.valueOf(globalMinDistance);
    }
    
    public static List<Integer> topKFreq(int[] array, int k) {
//        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int i : array) {
//            map.put(i, map.getOrDefault(i, 0) + 1);
//        }
//        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//            pq.add(entry);
//            if (pq.size() > k) {
//                pq.poll();
//            }
//        }
//
//        return pq.stream().map(a -> a.getKey()).collect(Collectors.toList());
        
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : array) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        
        return map.entrySet().stream().
            sorted((a, b) -> b.getValue() - a.getValue()).
            limit(k).
            map(a -> a.getKey()).
            collect(Collectors.toList());
    }
    
    public static String deleteNoneAlpha(String string) {
        StringBuilder sb = new StringBuilder();
        
        for (char c : string.toCharArray()) {
            if (Character.isAlphabetic(c)) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
    
    public static int deleteAlpha(String string) {
        StringBuilder sb = new StringBuilder();
        int num = 0;
        LinkedList<Integer> stack = new LinkedList<>();
        int sum = 0;
        for (char c : string.toCharArray()) {
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            } else {
                sum += num;
                stack.offerLast(num);
                num = 0;
            }
        }
        sum += num;
        stack.offerLast(num);
//        return stack.stream().mapToInt(a -> a).sum();
        return sum;
    }
    
    // fried fired
    public static void main(String[] args) {
        System.out.println(deleteAlpha("w123ell((*do1ne12"));
//        System.out.println(topKFreq(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 33, 3, 3, 3, 3, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7}, 3));
//        System.out.println(solve(new String[]{"water", "fox", "fire", "earth", "water", "fire", "water"}));
//        System.out.println(solve(new String[]{"water", "fox", "fire", "fire", "water", "fire", "water"}));
//        System.out.println(solve(new String[]{"water", "fox", "fire", "sun"}));
//        System.out.println(factorial(5));
//        System.out.println(max(new int[]{1, 2, 3, 5, 7, 4}));
//        System.out.println(isAnagram("fried", "fired"));
    }
}