package LeetCode;

public class MedianOfTwoSortedArrays_4 {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int N1 = nums1.length, N2 = nums2.length;
        if (N1 > N2) return findMedianSortedArrays(nums2, nums1);
        
        int lowIndex = 0;
        int highIndex = 2 * N1;
        while (lowIndex <= highIndex) {
            int index1 = (lowIndex + highIndex) / 2;
            int index2 = N1 + N2 - index1;
            
            double L1 = (index1 == 0) ? Integer.MIN_VALUE : nums1[(index1 - 1) / 2];
            double R1 = (index1 == 2 * N1) ? Integer.MAX_VALUE : nums1[index1 / 2];
            double L2 = (index2 == 0) ? Integer.MIN_VALUE : nums2[(index2 - 1) / 2];
            double R2 = (index2 == 2 * N2) ? Integer.MAX_VALUE : nums2[index2 / 2];
            
            if (L1 > R2) {
                highIndex = index1 - 1;
            } else if (L2 > R1) {
                lowIndex = index1 + 1;
            } else {
                return (Math.max(L1, L2) + Math.min(R1, R2)) / 2;
            }
        }
        return -1;
    }
    
    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{1, 2, 3, 5, 6, 7}, new int[]{1, 2, 4, 4}));
    }
}
