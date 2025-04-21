package LeetCode;

public class FindTheClosestPalindrome_564 {
    
    public static void main(String[] args) {
        System.out.println(new FindTheClosestPalindrome_564().nearestPalindromic("999"));

//        System.out.println(new FindTheClosestPalindrome_564().generatePalindromeFromLeft(123, true));
//        System.out.println(new FindTheClosestPalindrome_564().generatePalindromeFromLeft(123, false));
//
//        System.out.println(new FindTheClosestPalindrome_564().generatePalindromeFromLeft_II(123, true));
//        System.out.println(new FindTheClosestPalindrome_564().generatePalindromeFromLeft_II(123, false));
    }
    
    public String nearestPalindromic(String n) {
        long number = Long.parseLong(n);
        // 0. corner case
        // 如果数字是 1-10，则最接近的回文数始终是前一个数字。例如，对于 6，回文数是 5；对于 10，回文数是 9。
        // 如果数字是 11，则最接近的回文数是 9。
        if (number <= 10) {
            return String.valueOf(number - 1);
        }
        if (number == 11) {
            return "9";
        }
        
        int length = n.length();
        boolean isEvenLength = length % 2 == 0;
        long leftHalfNum = Long.parseLong(n.substring(0, (length + 1) / 2)); // 12345 -> 123
        // 12345 -> left: 123
        // 1234  -> left: 12
        Long[] palindromeCandidates = new Long[5];
        
        palindromeCandidates[0] = generatePalindrome(leftHalfNum - 1, isEvenLength);  // 12345 -> 122 -> 12221
        palindromeCandidates[1] = generatePalindrome(leftHalfNum, isEvenLength);             // 12345 -> 123 -> 12321
        palindromeCandidates[2] = generatePalindrome(leftHalfNum + 1, isEvenLength);  // 12345 -> 124 -> 12421
        
        palindromeCandidates[3] = (long) Math.pow(10, length) + 1;                           // 12345 -> 100001
        palindromeCandidates[4] = (long) Math.pow(10, length - 1) - 1;                       // 12345 ->   9999
        
        long nearestPalindrome = 0;
        long minDifference = Long.MAX_VALUE;
        
        for (long candidate : palindromeCandidates) {
            if (candidate == number) continue;
            long difference = Math.abs(candidate - number);
            if (difference < minDifference || (difference == minDifference && candidate < nearestPalindrome)) {
                minDifference = difference;
                nearestPalindrome = candidate;
            }
        }
        
        return String.valueOf(nearestPalindrome);
    }
    
    private long generatePalindrome(long leftHalfNum, boolean isEvenLength) {
        String leftHalfStr = String.valueOf(leftHalfNum);
        StringBuilder leftHalfStrSb = new StringBuilder(leftHalfStr);
        if (isEvenLength) {
            return Long.parseLong(leftHalfStr + leftHalfStrSb.reverse().toString());
        } else {
            return Long.parseLong(leftHalfStr.substring(0, leftHalfStr.length() - 1) + leftHalfStrSb.reverse().toString());
        }
    }
    
    private long generatePalindrome_II(long leftHalf, boolean isEvenLength) {
        long palindrome = leftHalf;
        if (!isEvenLength) leftHalf /= 10;
        while (leftHalf > 0) {
            palindrome = palindrome * 10 + leftHalf % 10;
            leftHalf /= 10;
        }
        return palindrome;
    }
    
}

//时间复杂度:O(d)，线性与输入数字的位数 d 成正比。
//空间复杂度:O(1)，只使用固定的空间存储候选数字和中间变量。

// https://leetcode.com/problems/find-the-closest-palindrome/solutions/5675172/o-1-beats-100-c-java-python-go-rust-javascript/

//1 - 由左半部分数字原样构成的回文。
//2 - 将数字的左半部分减一形成的回文。
//3 - 通过增加数字的左半部分形成的回文。
//4 - 全为 9 且比输入少一位的数字。
//5 - 末尾全为 0 和 1 的数字，比输入多一位数字。

//1-3：这些涵盖了最接近的回文数接近原始数字的情况。通过考虑当前左半部分及其递增和递减版本，
// 我们涵盖了一系列附近的回文数。因此，简单来说，最接近的回文数很可能非常接近我们的原始数字。
// 通过考虑这三个选项，我们正在回文世界中探索我们的数字的紧邻范围。
//4：这涵盖了最接近的回文数可能是位于我们数字下方的“9”回文数的情况。
// 例如，如果我们的数字是 1000，最接近的较小回文数是 999。
//5：这涵盖了最接近的回文数可能刚好在我们的数字上方，并且多了一个数字的情况。
// 例如，如果我们的数字是 999，最接近的较大回文数是 1001。
//
// 这些情况（4 和 5）发生在我们接近数字数量发生变化的“边界”时。为了处理这些问题，我们需要考虑另外两种特殊情况：
//i. 全是 9 的数字，比原始数字少一位
//ii. 数字全是 0（末尾有 1），比原始数字多一位

//1 - The palindrome formed by the left half of the number as is.
//2 - The palindrome formed by decrementing the left half of the number.
//3 -The palindrome formed by incrementing the left half of the number.
//4 - The number with all 9's that has one digit less than the input.
//5 - The number with all 0's and 1's at the ends that has one digit more than the input.