package LeetCode;

public class SqrtX_69 {
    public static int mySqrt_II(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        long left = 0;
        long right = x / 2 + 1;
        // make sure left + 1 = right
        // e.g., x = 8
        //       left = 3
        //       right = 4
        while (left + 1 < right) {
            long middle = left + (right - left) / 2;
            if (middle * middle == x) {
                return (int) middle;
            } else if (middle * middle > x) {
                right = middle;
            } else {
                left = middle;
            }
        }
        return (int) left;
    }
    
    public static void main(String[] args) {
        mySqrt_II(16);
    }
    
    public int mySqrt(int x) {
        long left = 0;
        long right = x;
        
        while (left + 1 < right) {
            long middle = left + (right - left) / 2;
            
            if (middle * middle == x) {
                return (int) middle;
            } else if (middle * middle < x) {
                left = middle;
            } else {
                right = middle;
            }
        }
        
        if (right * right == x) {
            return (int) right;
        }
        
        return (int) left;
    }
}
