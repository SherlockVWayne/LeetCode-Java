package LeetCode;

public class NumberOf1Bits_191 {
    public static int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            System.out.println(n);
            System.out.println(Integer.toBinaryString(n));
            System.out.println();
            
            count += n & 1;
            n >>>= 1;
        }
        return count;
    }
    
    public static void main(String[] args) {
        hammingWeight(2147483645);
    }
}
// The >>> operator is the unsigned right bit-shift operator in Java.
// It effectively divides the operand by 2 to the power of the right operand, or just 2 here.
// The unsigned right shift operator ">>>" shifts a zero into the leftmost position, while the leftmost position after ">>" depends on sign extension.

// The difference between >> and >>> would only show up when shifting negative numbers.
// The >> operator shifts a 1 bit into the most significant bit if it was a 1,
// and the >>> shifts in a 0 regardless.
