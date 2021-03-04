package LeetCode;

import java.util.*;

public class ZigZagConversion_6 {
    public String convert(String s, int numRows) {
        Map<Integer, StringBuilder> map = new HashMap();
        int pos = 0;
        boolean direction = true; // going downwards

        for (char c : s.toCharArray()) {
            if (pos == numRows) direction = false;
            if (pos == 1) direction = true;
            if (direction) pos++;
            else pos--;

            if (!map.containsKey(pos)) {
                map.put(pos, new StringBuilder());
            }
            map.get(pos).append(c);
        }
        StringBuilder result = new StringBuilder();
        for (int i : map.keySet()) {
            result.append(map.get(i));
        }
        return result.toString();
    }
}
