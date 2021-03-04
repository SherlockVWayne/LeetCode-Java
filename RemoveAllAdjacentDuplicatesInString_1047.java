package LeetCode;

public class RemoveAllAdjacentDuplicatesInString_1047 {
    public String removeDuplicates(String S) {
        char[] stack = new char[S.length()];
        int index = 0;

        for (char currentChar : S.toCharArray()) {
            if (index > 0 && stack[index - 1] == currentChar) {
                index --;
            } else {
                stack[index] = currentChar;
                index += 1;
            }
        }
        return new String(stack, 0, index);
    }
}
