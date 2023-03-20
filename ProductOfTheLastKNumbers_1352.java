package LeetCode;

import java.util.*;

public class ProductOfTheLastKNumbers_1352 {
    public ProductOfTheLastKNumbers_1352() {

    }

    ArrayList<Integer> A = new ArrayList() {{
        add(1);
    }};

    public void add(int num) {
        if (num > 0)
            A.add(A.get(A.size() - 1) * num);
        else {
            A = new ArrayList();
            A.add(1);
        }
    }

    public int getProduct(int k) {
        int n = A.size();
        return k < n ? A.get(n - 1) / A.get(n - k - 1) : 0;
    }


}
/**
 * Intuition
 * Similar to prefix sum. We can record the prefix product.
 * <p>
 * <p>
 * Explanation
 * If we meet 0, the product including this 0 will always be 0.
 * We only need to record the prefix product after it.
 * So I clear the A and reinitilise it as [1],
 * where 1 is the neutral element of multiplication.
 * <p>
 * <p>
 * Complexity
 * Time O(1) each
 * Space O(N)
 */
