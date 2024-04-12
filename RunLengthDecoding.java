package LeetCode;

public class RunLengthDecoding {
    // "2a1b3c" -> "aabccc"
    public static String runLengthDecoding(String input) {
        if (input == null || input.length() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        char currentChar = ' ';
        int currentCharCount = 0;
        for (char c : input.toCharArray()) {
            currentChar = c;
            if (Character.isDigit(c)) {
                currentCharCount = currentCharCount * 10 + (c - '0');
            } else {
                for (int i = 0; i < currentCharCount; i++) {
                    sb.append(c);
                }
                currentCharCount = 0;
            }
        }
        for (int i = 0; i < currentCharCount; i++) {
            sb.append(currentChar);
        }
        return sb.toString();
    }
    
    public static void main(String[] args) {
        System.out.println(runLengthDecoding("2a10b3c"));
    }
}
