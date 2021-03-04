package LeetCode;

import java.util.*;

public class RestoreIPAddresses_93 {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<String>();

        int n = s.length();

        for (int i = 1; i < n && i < 4; i ++) {
            String first = s.substring(0, i);
            if (!isValidPart(first)) continue;

            for (int j = 1; i + j < n && j < 4; j++) {
                String second = s.substring(i, i + j);
                if (!isValidPart(first)) continue;

                for (int k = 1; i + k + j < n && k < 4; k++) {
                    String third = s.substring(i + j, i + j + k);
                    String fourth = s.substring(i + j + k);

                    if (!isValidPart(third) || !isValidPart(fourth)) continue;
                    result.add(first + "." + second + "." + third + "." + fourth);
                }
            }
        }

        return result;
    }

    private boolean isValidPart(String s) {
        if (s.length() > 3) return false;
        if (s.startsWith("0") && s.length() > 1) return false;
        int value = Integer.parseInt(s);

        return value >= 0 && value <= 255;
    }
}
