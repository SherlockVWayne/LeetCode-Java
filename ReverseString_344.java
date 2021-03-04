package LeetCode;

public class ReverseString_344 {
    public void reverseString(char[] s) {
        int aPointer = 0;
        int bPointer = s.length - 1;

        while (aPointer <= bPointer) {
            char temp = s[aPointer];
            s[aPointer] = s[bPointer];
            s[bPointer] =temp;

            aPointer += 1;
            bPointer -= 1;
        }
    }
}
