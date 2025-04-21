package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class CompareVersionNumbers_Comparator {
    
    public static void main(String[] args) {
        List<String> versions = new ArrayList<>();
        versions.add("1.2");
        versions.add("1.1.0");
        versions.add("1.1-rc1");
        versions.add("1.1.2-alpha");
        versions.add("1.1.2-beta");
        versions.add("1.1.2-rc1");
        versions.add("1.1.2");
        versions.add("1.1-beta");
        versions.add("1.1.0-rc1");
        List<String> sortedVersions = VersionComparator.compareVersion(versions);
        sortedVersions.forEach(System.out::println);
    }
}

class VersionComparator implements Comparator<String> {
    private static String[] PRE_RELEASE_VERSIONS = new String[]{"alpha", "beta"};
    
    public static List<String> compareVersion(List<String> versions) {
        versions.sort(new VersionComparator());
        return versions;
    }
    
    @Override
    public int compare(String version1, String version2) {
        String[] v1Parts = version1.split("[.-]");
        String[] v2Parts = version2.split("[.-]");
        
        int length = Math.max(v1Parts.length, v2Parts.length);
        
        for (int i = 0; i < length; i++) {
            String v1Part = i < v1Parts.length ? v1Parts[i] : "0";
            String v2Part = i < v2Parts.length ? v2Parts[i] : "0";
            
            if (isNumeric(v1Part) && isNumeric(v2Part)) {
                int num1 = Integer.parseInt(v1Part);
                int num2 = Integer.parseInt(v2Part);
                if (num1 != num2) {
                    return Integer.compare(num1, num2);
                }
            }
            // alpha, beta comes first than numbers
            else if (isNumeric(v1Part) &&
                (v2Part.toLowerCase().startsWith("alpha") || v2Part.toLowerCase().startsWith("beta"))) {
                return 1;
            } else if (isNumeric(v2Part) &&
                (v1Part.toLowerCase().startsWith("alpha") || v1Part.toLowerCase().startsWith("beta"))) {
                return -1;
            } else if (!isPreRelease(v1Part) && !isPreRelease(v2Part)) {
                return v1Part.compareTo(v2Part);
            } else {
                int preReleaseCompare = comparePreRelease(v1Part, v2Part);
                if (preReleaseCompare != 0) {
                    return preReleaseCompare;
                }
            }
        }
        return 0; // 版本号相同
    }
    
    private boolean isNumeric(String str) {
        return str.matches("\\d+");
    }
    
    private int comparePreRelease(String v1Part, String v2Part) {
        int v1Rank = getPreReleaseRank(v1Part, PRE_RELEASE_VERSIONS);
        int v2Rank = getPreReleaseRank(v2Part, PRE_RELEASE_VERSIONS);
        
        return Integer.compare(v1Rank, v2Rank);
    }
    
    private int getPreReleaseRank(String part, String[] preReleaseOrder) {
        for (int i = 0; i < preReleaseOrder.length; i++) {
            if (part.startsWith(preReleaseOrder[i])) {
                return i;
            }
        }
        return preReleaseOrder.length; // 排在最后
    }
    
    private boolean isPreRelease(String version) {
        return Arrays.stream(PRE_RELEASE_VERSIONS).toList().contains(version.toLowerCase());
    }
}