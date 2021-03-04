package LeetCode;

public class ToLowerCase_709 {
    public String toLowerCase(String str) {
        String result = "";
        for (char c : str.toCharArray()) {
            if (Character.isUpperCase(c)) {
                result += (char)(c + 32);
            } else {
                result += c;
            }
        }
        return result;
    }
}
