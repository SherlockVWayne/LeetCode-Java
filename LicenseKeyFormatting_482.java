package LeetCode;

public class LicenseKeyFormatting_482 {
    public String licenseKeyFormatting(String S, int K) {
        S = S.toUpperCase();
        S = S.replaceAll("-", "");

        StringBuilder stringBuilder = new StringBuilder(S);

        for (int i = S.length() - K; i > 0; i -= K) {
            stringBuilder.insert(i, "-");
        }
        return stringBuilder.toString();
    }
}
