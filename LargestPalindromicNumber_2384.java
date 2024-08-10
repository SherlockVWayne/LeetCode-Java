package LeetCode;

import java.util.*;

public class LargestPalindromicNumber_2384 {
    public String largestPalindromic(String num) {
        int[] numFreq = new int[10];
        for (char c : num.toCharArray()) {
            numFreq[c - '0'] += 1;
        }
        
        if (numFreq[0] == num.length()) {
            return "0";
        }
        
        StringBuilder firstHalf = new StringBuilder();
        
        char middle = 'a';
        boolean hasMiddle = false;
        
        for (int i = 9; i >= 0; i--) {
            if (!hasMiddle && numFreq[i] % 2 == 1) {
                hasMiddle = true;
                middle = (char) (i + '0');
            }
            
            int halfFreq = numFreq[i] / 2;
            while (halfFreq-- > 0) {
                firstHalf.append(i);
            }
        }
        
        // "00009"
        if (firstHalf.length() > 0 && firstHalf.charAt(0) == '0') {
            return String.valueOf(middle);
        }
        
        StringBuilder lastHalf = new StringBuilder(firstHalf);
        if (hasMiddle) {
            firstHalf.append(middle);
        }
        return firstHalf.append(firstHalf.reverse()).toString();
    }
}
//Step 1: Hash all the elements of the given number string.
//Step 2: Check the base case: if all the elements are '0' in the number, return "0".
//Step 3:
//   - Iterate from the last to the first in the hash array.
//   - Check if an odd frequency of an element is present in the hash. If found, store it in the middle variable. Use a flag variable to ensure the middle element is not chosen again.
//   - Divide the frequency by 2 and append the element to the first string until the frequency becomes 0. This process generates the first half of the largest palindromic number up to the least element in the original number.
//Step 4: Check if the middle element of the palindromic number is present using the middle_flag variable. If present, append the middle variable to the first string.
//Step 5: Store the last part of the largest palindromic number by reversing the first string (which contains the first half) and appending it to the first string. Then return the first string.

//Time complexity: O(n) --> Traversing the array takes O(n)
//Space complexity: O(n) --> The hash array has a constant size (10 in this case) and does not depend on the size of the input.
//                           The StringBuilder objects first and last can grow up to the size of the input array, making the overall space complexity linear with respect to the input size.

