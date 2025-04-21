package LeetCode;

public class ShortestPalindrome_214 {
    public String shortestPalindrome(String s) {
        String t = new StringBuilder(s).reverse().toString();
        for (int i = 0; i < t.length(); i++) {
            if (s.startsWith(t.substring(i))) {
                return t.substring(0, i) + s;
            }
        }
        return t + s;
    }
}
//Reverse the input string s to get t.
//We will look for the longest prefix of s that matches a suffix of t.
//Check for Prefix Match:
//
//Iterate through the reversed string t.
//For each character in t, check if the original string s starts with the suffix of t beginning at the current index i.
//If a match is found (i.e., a prefix of s matches a suffix of t), that means we can create a palindrome by prepending the unmatched portion of t to s.
//Form the Shortest Palindrome:
//
//Once the largest prefix-suffix match is found, the unmatched part of t (i.e., t.substring(0, i)) is prepended to s to form the shortest palindrome.
//If no prefix-suffix match is found (which happens in the worst case when no part of s is a palindrome), we append the entire reversed string t in front of s.
//
//Time complexity:
//O(n^2)
//
//Space complexity:
//O(n)