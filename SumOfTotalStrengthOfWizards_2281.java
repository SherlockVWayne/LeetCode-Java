package LeetCode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class SumOfTotalStrengthOfWizards_2281 {
    public static int totalStrength_II(int[] A) {
        int result = 0;
        int accumulatedStrength = 0;
        int mod = (int) 1e9 + 7;
        Stack<Integer> stack = new Stack<>();
        int[] accumulatedStrengthArray = new int[A.length + 2];
        for (int wizardIndex = 0; wizardIndex <= A.length; wizardIndex++) {
            int wizardStrength = wizardIndex < A.length ? A[wizardIndex] : 0;
            accumulatedStrength = (accumulatedStrength + wizardStrength) % mod;
            accumulatedStrengthArray[wizardIndex + 1] = (accumulatedStrength + accumulatedStrengthArray[wizardIndex]) % mod;
            while (!stack.isEmpty() && A[stack.peek()] > wizardStrength) {
                int i = stack.pop();
                int l = stack.isEmpty() ? -1 : stack.peek();
                long lacc = l < 0 ? accumulatedStrengthArray[i] :
                    accumulatedStrengthArray[i] - accumulatedStrengthArray[l];
                long racc = accumulatedStrengthArray[wizardIndex] - accumulatedStrengthArray[i];
                int ln = i - l, rn = wizardIndex - i;
                result = (int) (result + (racc * ln - lacc * rn) % mod * A[i] % mod) % mod;
            }
            stack.push(wizardIndex);
        }
        return (result + mod) % mod;
    }

//    Key words
//    Subarray + sum -> prefix sum
//    Subarray + minimum -> mono stack
//
//    Intuition
//    Assume A[i] is the leftmost smallest element in a subarray,
//    calculate each A[i] contibution
//
//    Explanation
//    1 - Find next small on the right
//    2 - Find next small or equal on the left.
//    3 - For each A[i] as the minimum, find the possible subarray sums.
//
//    Complexity
//    Time O(n)
//    Space O(n)
    
    public static void main(String[] args) {
        System.out.println(totalStrength_II(new int[]{1, 2, 3, 4, 1, 2}));
    }
    
    static int mod = (int) 1e9 + 7;
    
    public int totalStrength(int[] nums) {
        int n = nums.length;
        long[] forward = new long[n], backward = new long[n], prefix = new long[n + 1], suffix = new long[n + 1];
        forward[0] = prefix[1] = nums[0];
        backward[n - 1] = suffix[n - 1] = nums[n - 1];
        for (int i = 1; i < n; ++i) {
            forward[i] = nums[i] + forward[i - 1];
            prefix[i + 1] = prefix[i] + forward[i];
        }
        for (int i = n - 2; 0 <= i; --i) {
            backward[i] = nums[i] + backward[i + 1];
            suffix[i] = suffix[i + 1] + backward[i];
        }
        long res = 0;
        Deque<Integer> dq = new LinkedList();
        for (int i = 0; i < n; ++i) {
            while (!dq.isEmpty() && nums[dq.peekLast()] >= nums[i]) {
                int cur = dq.pollLast(), prev = dq.isEmpty() ? -1 : dq.peekLast();
                res = (res + getSum(nums, forward, prefix, backward, suffix, prev, cur, i) * nums[cur]) % mod;
            }
            dq.add(i);
        }
        while (!dq.isEmpty()) {
            int cur = dq.pollLast(), prev = dq.isEmpty() ? -1 : dq.peekLast();
            res = (res + getSum(nums, forward, prefix, backward, suffix, prev, cur, n) * nums[cur]) % mod;
        }
        return (int) res;
    }
    
    private long getSum(int[] nums, long[] forward, long[] prefix, long[] backward, long[] suffix, int prev, int cur, int next) {
        long sum = ((cur - prev) * (long) nums[cur] % mod) * (next - cur) % mod;
        long preSum = getPresum(backward, suffix, prev + 1, cur - 1, next - cur);
        long postSum = getPostsum(forward, prefix, cur + 1, next - 1, cur - prev);
        return (sum + preSum + postSum) % mod;
    }
    
    private long getPresum(long[] backward, long[] suffix, int from, int to, int m) {
        int n = backward.length, cnt = to - from + 1;
        return (suffix[from] - suffix[to + 1] - cnt * (to + 1 == n ? 0 : backward[to + 1]) % mod) % mod * m % mod;
    }
    
    private long getPostsum(long[] forward, long[] prefix, int from, int to, int m) {
        int n = forward.length, cnt = to - from + 1;
        return (prefix[to + 1] - prefix[from] - cnt * (0 == from ? 0 : forward[from - 1]) % mod) % mod * m % mod;
    }
//Just like the system design, we need to understand the system scale first. According to the constraint, we must solve the problem in O(NLogN) or O(N).
//My initial thought is that I can find out the range for each element such that the element is the minimum element among all continuous subarray within that specific range. And this can be done in O(N).
//If this direction is correct, the next problem will be how I can calculate the sum of all the continuous subarray in O(N)? It seems like I need to apply the prefix sum approach, but how can I use it? To figure it out, I drew an example.
//Let's look at the example [a0, a1, a2, a3, a4, a5, a6, a7, a8] and assume a3 is the minimum value for range a1 to a6 so that the possible subarrays can be generate by the following equation:
//[]                                          []
//[a2]                                        [a4]
//x       a3      x         [a4, a5]
//[a1, a2]                                    [a4, a5, a6]
//From the above equation, I conclue the sum of the subarrays can be divided into 3 parts:
//Prefix sum = Sum([a2], [a1, a2]) x number of the possible end points on the right hand sight
//Middle sum = number of possible end points on the left hand side x a3 x number of possible end points on the right hand side
//Post sum = Sum([a4], [a4, a5], [a4, a5, a6]) x number of possible end points on the left hand side
//To figure out how to calculate the sum of continuous subarrays, I start from drawing the prefix sum array and observe the relationship between the target and prefix sum array.
//Input:  [a0, a1, a2, a3, a4]
//Prefix:[[a0], [a0, a1], [a0, a1, a2], [a0, a1, a2, a3], [a0, a1, a2, a3, a4]]
//Target range a3 to a4: [a3] + [a3, a4]
//After careful observation, I found
//
//Target [a3] + [a3, a4] = [a0, a1, a2, a3] + [a0, a1, a2, a3, a4] - 2 x [a0, a1, a2]
//Thus, I need the second prefix sum array to help calculate sum of continuous subarray in O(N).
}