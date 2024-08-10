package LeetCode;

public class JumpGame_III_1306 {
    public boolean canReach(int[] arr, int start) {
        return 0 <= start &&
            start < arr.length &&
            arr[start] >= 0 &&
            ((arr[start] = -arr[start]) == 0 ||
                canReach(arr, start + arr[start]) ||
                canReach(arr, start - arr[start]));
    }
}

// Check 0 <= i < A.length
// flip the checked number to negative A[i] = -A[i]
// If A[i] == 0, get it and return true
// Continue to check canReach(A, i + A[i]) and canReach(A, i - A[i])
// Complexity
// Time O(N), as each number will be flipper at most once.
// Space O(N) for recursion.
