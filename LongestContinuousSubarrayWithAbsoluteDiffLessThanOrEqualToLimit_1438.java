package LeetCode;

import java.util.Deque;
import java.util.LinkedList;

public class LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit_1438 {
    
    public static void main(String[] args) {
        System.out.println(new LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit_1438().longestSubarray(
            new int[]{10, 1, 2, 4, 7, 2},
            5
        ));
    }
    
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> maxDeque = new LinkedList<>();
        Deque<Integer> minDeque = new LinkedList<>();
        // maintain max, min in current window
        
        int left = 0;
        int maxLength = 0;
        
        for (int right = 0; right < nums.length; right++) {
            // Maintain the maxDeque in decreasing order
            while (!maxDeque.isEmpty() && maxDeque.peekLast() < nums[right]) {
                maxDeque.pollLast();
            }
            maxDeque.offerLast(nums[right]);
            
            // Maintain the minDeque in increasing order
            while (!minDeque.isEmpty() && minDeque.peekLast() > nums[right]) {
                minDeque.pollLast();
            }
            minDeque.offerLast(nums[right]);
            
            // Check if the current window exceeds the limit
            while (maxDeque.peekFirst() - minDeque.peekFirst() > limit) {
                // Remove the elements that are out of the current window
                if (maxDeque.peekFirst() == nums[left]) {
                    maxDeque.pollFirst();
                }
                if (minDeque.peekFirst() == nums[left]) {
                    minDeque.pollFirst();
                }
                left++;
            }
            
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }
}

// i 初始化：
//     初始化两个双端队列，maxDeque和minDeque。
//     初始化left为0表示滑动窗口的开始。
//     初始化maxLength以0存储最长有效子数组的长度。
// ii nums使用变量从左到右遍历数组right：
//     对于每个元素nums[right]：
//         保持maxDeque降序排列：
//             当 maxDeque 不为空且 maxDeque 中的最后一个元素maxDeque小于 时nums[right]：
//                 从 maxDeque 中删除最后一个元素maxDeque。
//             加到nums[right]的后面maxDeque。
//         保持 minDeque 递增顺序：
//             当minDeque不为空且 中的最后一个元素minDeque大于 时nums[right]：
//                 从 minDeque 中删除最后一个元素minDeque。
//             加到nums[right]的后面minDeque。
//         检查当前窗口是否超出限制：
//             maxDeque而和的第一个元素之间的绝对差minDeque大于limit：
//         更新maxLength：
//             设置为和maxLength的最大值。maxLength(right - left + 1)
// iii 返回maxLength存储最长有效子数组的长度。

// 时间复杂度：O(n)
// 初始化两个双端队列maxDeque和minDeque需要O(1)时间。
// nums从左到右遍历数组涉及运行的单个循环n次。
// 维护maxDeque和minDeque删除元素涉及添加和删除元素。每个元素最多可以从双端队列添加和删除一次，从而导致欧( 1 )每次操作的时间。在整个阵列上，这导致在）​​两个双端队列的总时间。

// 空间复杂度：O(n)
// 两个双端队列maxDeque和minDeque存储数组元素。在最坏的情况下，每个双端队列可以存储所有n数组的元素。
// 附加变量left、right和maxLength使用常量空间。