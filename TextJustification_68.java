package LeetCode;

import java.util.*;

public class TextJustification_68 {
    public static List<String> fullJustify(String[] words, int maxWidth) {
        if (words == null || words.length == 0 || maxWidth == 0) {
            return new ArrayList<String>();
        }
        
        List<String> lines = new ArrayList<String>();
        
        int index = 0;
        
        while (index < words.length) {
            int count = words[index].length(); // length of current word
            int last = index + 1;
            
            while (last < words.length) {
                if (words[last].length() + count > maxWidth - 1) {
                    break;
                }
                count += words[last].length() + 1;
                last++;
            }
            // update the count as the max length this word could extend to
            // words[last - 1] should be the final word which could be added to this line
            
            StringBuilder stringBuilder = new StringBuilder();
            int difference = last - index - 1; // how many more words would be in this line
            
            if (last == words.length || difference == 0) {
                // left-justified
                // if last line or number of words in the line is 1
                for (int i = index; i < last; i++) {
                    stringBuilder.append(words[i] + " ");
                }
                stringBuilder.deleteCharAt(stringBuilder.length() - 1); // delete the final " "
                for (int i = stringBuilder.length(); i < maxWidth; i++) {
                    stringBuilder.append(" ");
                }
            } else {
                // middle justified
                int spaces = (maxWidth - count) / difference; // extra spaces should be added to be middle justified
                int rightSpaces = (maxWidth - count) % difference;
                // if rightSpaces == 0:
                // "This[ ][ ][ ]is[ ][ ][ ]the"
                // if rightSpaces > 0:
                // "This[ ][ ][ ]is[ ][ ][ ]the[ ][ ]"
                for (int i = index; i < last; i++) {
                    stringBuilder.append(words[i]);
                    if (i < last - 1) { // not reach to the end of this line yet, need to append extra spaces
                        for (int j = 0; j <= (spaces + ((i - index) < rightSpaces ? 1 : 0)); j++) {
                            stringBuilder.append(" ");
                        }
                    }
                }
            }
            
            lines.add(stringBuilder.toString());
            index = last;
        }
        return lines;
    }
    
    public static void main(String[] args) {
        List<String> result = fullJustify(new String[]{"This", "is", "an", "example", "of", "text", "justification."}, 16);
        for (String s : result) {
            System.out.println(s);
        }
    }
}
