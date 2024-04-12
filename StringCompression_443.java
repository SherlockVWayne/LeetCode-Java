package LeetCode;

public class StringCompression_443 {
    public int compress(char[] chars) {
        if (chars == null || chars.length == 0) return 0;
        int index = 0; // index of current char
        int start = 0; // start of non-compressed string
        int count = 0; // frequency of current character
        
        for (; index < chars.length; index++) {
            count++; // current character frequency += 1
            if (index == chars.length - 1 ||         // if meets end of chars
                chars[index] != chars[index + 1]) {  // if next character is different from current char
                chars[start] = chars[index];
                start++;
                
                if (count != 1) { // now statistic for current char freq is complete
                    // copy the frequency number into original chars array
                    char[] frequencyArray = String.valueOf(count).toCharArray();
                    for (int i = 0; i < frequencyArray.length; i++, start++) {
                        chars[start] = frequencyArray[i];
                    }
                }
                // reset the count
                count = 0;
            }
        }
        return start;
    }
    
    // [a, a, a, a, a, a, a, a, a, a, a, a, b, b, b, c]
    // [a, 1, 2, b, 3, c, a, a, a, a, a, a, b, b, b, c]
    //                    |
    //                  start
}
