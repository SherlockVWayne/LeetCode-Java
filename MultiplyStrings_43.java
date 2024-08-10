package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class MultiplyStrings_43 {
    public static String multiply(String num1, String num2) {
        int length1 = num1.length();
        int length2 = num2.length();
        int[] resultArray = new int[length1 + length2];
        for (int i = length1 - 1; i >= 0; i--) {
            for (int j = length2 - 1; j >= 0; j--) {
                int multiplication = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int sum = multiplication + resultArray[i + j + 1];
                // 3 * 6 = 18
                resultArray[i + j] += sum / 10;
                // 8 is at end of result          [0, 0, 0, 0, 0, 8]
                resultArray[i + j + 1] = sum % 10;
                // 1 is carryout for multi result [0, 0, 0, 0, 1, 8]
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i : resultArray) {
            if (sb.length() != 0 || i != 0) sb.append(i);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
    
    public static void main(String[] args) {
        System.out.println(multiply("120", "430"));
        List<Integer>[] listArr = new ArrayList[4];
    }
    
    public static String multiply_1(String num1, String num2) {
        return String.valueOf(Integer.parseInt(num1) * Integer.parseInt(num2));
    }
}
