package LeetCode;

import java.util.*;

public class PartitionLabel_763 {
    public static List<Integer> partitionLabels(String S) {
        if (S == null || S.length() == 0) return null;
        
        List<Integer> result = new ArrayList();
        int[] lastIndices = new int[26];
        // record last appearance index of the char
        for (int i = 0; i < S.length(); i++) {
            lastIndices[S.charAt(i) - 'a'] = i;
        }
        int start = 0;
        int end = 0;
        for (int i = 0; i < S.length(); i++) {
            end = Math.max(end, lastIndices[S.charAt(i) - 'a']);
            if (i == end) {
                result.add(end - start + 1);
                start = end + 1;
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        Print.printIntList(partitionLabels("ababcbacadefegdehijhklij"));
    }
    
}
