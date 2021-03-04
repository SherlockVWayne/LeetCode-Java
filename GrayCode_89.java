package LeetCode;

import java.util.*;

public class GrayCode_89 {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList();
        for (int i = 0; i < 1 << n; i++)  result.add(i ^ i >> 1);
        return result;
    }
}
/**
 * n = 2 -> 10
 * i = 0 ; i < 100 = 4
 *  i  ^ ( i  >> 1 )
 * 000 ^ (000 >> 1 ) = 000
 *
 * i = 1 ; i < 100 = 4
 *  i  ^ ( i  >> 1 )
 * 001 ^ (001 >> 1) = 001
 *
 * i = 2 ; i < 100 = 4
 *  i  ^ ( i  >> 1 )
 * 010 ^ (010 >> 1) = 011
 */