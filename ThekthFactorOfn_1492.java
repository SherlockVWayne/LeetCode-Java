package LeetCode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class ThekthFactorOfn_1492 {
    public int kthFactor(int n, int k) {
        LinkedList<Integer> factorList = new LinkedList<Integer>();
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                factorList.add(i);
            }
        }
        return k > factorList.size() ? -1 : factorList.get(k - 1);
    }
}
