package LeetCode;

import java.util.*;

public class FizzBuzz_412 {
    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();
        for (int i = 1; i < n + 1; i ++) {
            if (i % 3 == 0 && i % 5 != 0) {
                result.add("Fizz");
            } else if (i % 5 == 0 && i % 3 != 0) {
                result.add("Buzz");
            } else if (i % 3 == 0 && i % 5 == 0) {
                result.add("FizzBuzz");
            } else {
                result.add(Integer.toString(i));
            }
        }
        return result;
    }

    public List<String> fizzBuzz_II(int n) {
        List<String> result = new ArrayList<>();
        for (int i = 1, fizz = 0, buzz = 0; i <= n; i ++) {
            fizz ++;
            buzz ++;

            if (fizz == 3 && buzz == 5) {
                result.add("FizzBuzz");
                fizz = 0;
                buzz = 0;
            } else if (fizz == 3) {
                fizz = 0;
                result.add("Fizz");
            } else if (buzz == 5) {
                buzz = 0;
                result.add("Buzz");
            } else {
                result.add(Integer.toString(i));
            }
        }
        return result;
    }
}
