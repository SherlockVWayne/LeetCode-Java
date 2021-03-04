package LeetCode;

import java.util.*;

public class PartitionLabel_763 {
    public List<Integer> partitionLabels(String S) {
        if (S == null || S.length() == 0) return null;

        List<Integer> output = new ArrayList();
        int[] lastIndices = new int[26];
        for (int i = 0; i < S.length(); i ++) {
            lastIndices[S.charAt(i) - 'a'] = i;
        }
        int start = 0;
        int end = 0;
        for (int i = 0; i < S.length(); i ++) {
            end = Math.max(end, lastIndices[S.charAt(i) - 'a']);
            if (i == end) {
                output.add(end - start + 1);
                start = end + 1;
            }
        }

        return output;
    }
}
