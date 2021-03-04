package LeetCode;

public class NumberOfLinesToWriteString_806 {
    public int[] numberOfLines(int[] widths, String s) {
        int[] result = new int[2];

        int numLines = 1;
        int width = 0;

        for (char c : s.toCharArray()) {
            int charWidth = widths[c - 'a'];
            if (charWidth + width > 100) {
                numLines ++;
                width = 0;
            }
            width += charWidth;
        }

        result[0] = numLines;
        result[1] = width;

        return result;
    }
}
