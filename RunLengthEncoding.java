package LeetCode;

public class RunLengthEncoding {
    // "aabccc" -> "2a1b3c"
    public static String runLengthEncoding(String input) {
        if (input == null || input.length() == 0) {
            return "";
        }
        
        char preChar = input.charAt(0);
        int count = 0;
        
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == preChar) {
                count += 1;
            } else {
                result.append(count).append(preChar);
                preChar = input.charAt(i);
                count = 1;
            }
        }
        result.append(count).append(preChar);
        return result.toString();
    }
    
    public static void main(String[] args) {
        System.out.println(runLengthEncoding("aabccca"));
    }
}
