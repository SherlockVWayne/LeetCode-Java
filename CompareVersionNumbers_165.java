package LeetCode;

public class CompareVersionNumbers_165 {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        
        for (int i = 0; i < Math.max(v1.length, v2.length); i++) {
            int ver1 = i < v1.length ? Integer.parseInt(v1[i]) : 0;
            int ver2 = i < v2.length ? Integer.parseInt(v2[i]) : 0;
            if (ver1 > ver2) {
                return 1;
            } else if (ver1 < ver2) {
                return -1;
            }
        }
        
        return 0;
    }
}
