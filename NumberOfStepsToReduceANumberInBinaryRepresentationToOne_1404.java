package LeetCode;

public class NumberOfStepsToReduceANumberInBinaryRepresentationToOne_1404 {
    public int numSteps(String s) {
        int result = 0;
        int carry = 0;
        for (int i = s.length() - 1; i > 0; i--) {
            result++;
            if ((s.charAt(i) - '0') + carry == 1) {
                carry = 1;
                result++;
            }
        }
        return result + carry;
    }
}
//    Intuition: division by two is the same as the right shift by one bit (character). If the bit is 0, we just do the shift - one operation. If the bit is 1 - we do plus one, and our bit changes to zero. So, we set carry to 1 and shift. Two operations.
//
//    Algorithm
//    We have three phases here:
//
//    1 - We haven't encountered any 1. Every char adds one operation.
//    2 - We encounter our first 1. We set carry to 1 and add two operations.
//    3 - The rest:
//      3A. Every 1 needs one operation (carry makes it 0). carry is still 1 due to addition.
//      3B. Every 0 needs two operations (carry makes it 1). carry is still 1 as we need to add 1 in this case.
