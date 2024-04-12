package LeetCode;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaximumNumberOfBooksYouCanTake_2355 {
    private static long getSummation(int n) {
        if (n < 0) {
            return 0;
        }
        
        return (long) ((long) n * (long) (n + 1)) / 2;
    }
    
    public static long maximumBooks(int[] books) {
        if (books == null || books.length == 0) {
            return 0;
        }
        long[] dp = new long[books.length];
        
        // dp[i] represents max number of books that can be taken
        // between shelf 0 and shelf i (both inclusive)
        
        // use monotonic stack to populate dp array; for every index i,
        // find the nearest break point j < i such that books[i - j] <
        // books[i] - i + j
        
        // this becomes the restraining point for picking books as now
        // instead of picking (books[i] - i + j) books, we can only pick
        // books[i - j] books; so we will pick the maximum dp[j] books +
        // (books[i] + books[i] - 1 + books[i] - 2 + ... + books[i] - (i - j - 1))
        Deque<Integer> stack = new ArrayDeque<Integer>();
        long maxBooks = 0;
        
        for (int i = 0; i < books.length; i++) {
            while (!stack.isEmpty() && books[stack.peek()] >= books[i] - i + stack.peek()) {
                stack.pop();
            }
            // pick dp[j] books and (books[i] + books[i] - 1 + ... + books[i] -
            // (i - j - 1)) books, where j is the current stack top; the latter
            // expression can be rewritten as a difference of two n-summations
            dp[i] = (stack.isEmpty() ? 0 : dp[stack.peek()]) + getSummation(books[i]) - getSummation(books[i] - i + (stack.isEmpty() ? -1 : stack.peek()));
            
            maxBooks = Math.max(maxBooks, dp[i]);
            stack.push(i);
            
            System.out.print("dp:");
            for (long n : dp) {
                System.out.print(n + " ");
            }
            System.out.println();
            
            System.out.print("stack:");
            for (int n : stack) {
                System.out.print(n + " ");
            }
            System.out.println();
        }
        
        return maxBooks;
    }
    
    public static void main(String[] args) {
        System.out.println(maximumBooks(new int[]{8, 5, 2, 7, 9}));
    }
}
/**
 * From the books array, we want to maximize the number of books that can be taken between a closed interval (l, r), where 0 <= l < r < n. Given the constraints in the problem, it becomes evident that for every such closed interval (l, r), we need to pick all the books in the shelf r, i.e., all of books[r].
 * <p>
 * Having fixed an r, we want to know what is the maximum number of books we can pick in the interval (0, r), and use it for calculating the same information for all possible values of r in (0, n - 1). Hence, dynamic programming.
 * <p>
 * Let us look at a random example for better understanding:
 * <p>
 * Say, we have the 0-indexed books array [2, 1, 4, 8, 6, 7]. Our dp array should look like this (we will see why; also, let's consider dp[-1] = 0 only for understanding):
 * <p>
 * dp[0] = 2 (since we need to pick all books from the 0th shelf, pretty obvious)
 * dp[1] = 1 (1 book from 1st shelf, 0 from 0th shelf)
 * dp[2] = 5 (4 books from 2nd shelf, 1 from 1st shelf, 0 from 0th shelf)
 * dp[3] = 13 (8 books from 3rd shelf, 4 from 2nd shelf, 1 from 1st shelf, 0 from 0th shelf)
 * dp[4] = 16 (6 books from 4th shelf, 5 from 3rd shelf, 4 from 2nd shelf, 1 from 1st shelf, 0 from 0th shelf)
 * dp[5] = 23 (7 books from 5th shelf, 6 from 4th shelf, 5 from 3rd shelf, 4 from 2nd shelf, 1 from 1st shelf, 0 from 0th shelf)
 * <p>
 * A pattern can be noticed here:
 * dp[0] = dp[-1] + 2
 * dp[1] = dp[-1] + (0 + 1)
 * dp[2] = dp[1] + 4
 * dp[3] = dp[2] + 8
 * dp[4] = dp[1] + (4 + 5 + 6)
 * dp[5] = dp[1] + (4 + 5 + 6 + 7)
 * <p>
 * For every index i, we need the index j < i, such that dp[i] can be derived from dp[j] using a summation. Basically for any index i, j is the first index to the left of i where books[j] < books[i] - i + j. This index j is obtained using a monotonic stack.
 */
