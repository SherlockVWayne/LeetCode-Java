package LeetCode;

/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class FirstBadVersion_278 {
    public boolean isBadVersion(int version) {
        return version % 2 == 0;
    }

    public int firstBadVersion(int n) {
        int leftIndex = 0;
        int rightIndex = n;

        while (leftIndex < rightIndex) {
            int middleIndex = leftIndex + (rightIndex - leftIndex) / 2;
            if (isBadVersion(middleIndex)) {
                rightIndex = middleIndex;
            } else {
                leftIndex = middleIndex + 1;
            }
        }
        if (leftIndex == rightIndex && isBadVersion(leftIndex)) {
            return leftIndex;
        }
        return -1;
    }
}
