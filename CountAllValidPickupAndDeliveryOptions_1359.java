package LeetCode;

public class CountAllValidPickupAndDeliveryOptions_1359 {
    public int countOrders(int n) {
        long result = 1;
        long mod = (long) 1e9 + 7;
        for (int i = 2; i <= n; i++) {
            result = result * (i * 2 - 1) * i % mod;
        }
        return (int) result;
    }
    
    public int countOrders_I(int n) {
        long result = 1;
        long mod = (long) 1e9 + 7;
        for (int i = 1; i <= n; ++i) {
            result = result * (i * 2 - 1) * i % mod;
        }
        return (int) result;
    }
}
// Assume we have already n-1 pairs,now we need to insert the nth pair.
// To insert the first element,there are n*2-1 choice of position。
// To insert the second element,there are n*2 choice of position。
// So there are (n*2-1)*n*2 permutations.
// Considering that delivery(i) is always after of pickup(i),we need to divide 2.
// So it's (n * 2 - 1) * n.
//
// For each run, Time O(N), Space O(1).
// Also we can cache the result, so that O(1) amortized for each n.
// But in doesn't help in case of LC.
// Also we can pre calculate all results, so that we have O(N) space and O(1) time.