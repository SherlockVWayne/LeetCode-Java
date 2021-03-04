package LeetCode;

public class MultiplyStrings_43 {
    public String multiply(String num1, String num2) {
        int n = num1.length();
        int m = num2.length();

        int[] arr = new int[m + n];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                int multiplication  = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int sum = arr[i + j + 1] + multiplication;
                arr[i + j + 1] = sum % 10;
                arr[i + j] += sum / 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i : arr) {
            if (sb.length() != 0 || i != 0) {
                sb.append(i);
            }
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }
}
