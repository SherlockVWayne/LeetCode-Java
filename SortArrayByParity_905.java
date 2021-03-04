package LeetCode;

public class SortArrayByParity_905 {
    public int[] sortArrayByParity(int[] A) {
        int[] result = new int[A.length];
        int counter = 0;

        for (int i = 0; i < A.length; i ++) {
            if (A[i] % 2 == 0) {
                result[counter] = A[i];
                counter ++;
            }
        }

        for (int i = 0; i < A.length; i ++) {
            if (A[i] % 2 != 0) {
                result[counter] = A[i];
                counter ++;
            }
        }

        return result;
    }

    public int[] sortArrayByParity_II(int[] A) {
        int i = 0;
        int j = A.length - 1;

        while (i < j) {
            if (A[i] % 2 > A[j] % 2) {
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }

            if (A[i] % 2 == 0) i ++;
            if (A[j] % 2 == 1) j --;
        }

        return A;
    }
}
