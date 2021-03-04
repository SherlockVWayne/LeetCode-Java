package LeetCode;

public class ConvertSortedArrayToBinarySearchTree_108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0)  return null;
        return constructTreeFromArray(nums, 0, nums.length - 1);
    }

    public TreeNode constructTreeFromArray(int[] nums, int left, int right) {
        if (left > right) return null;
        int middle = left + (right - left) / 2;

        TreeNode node = new TreeNode(nums[middle]);
        node.left = constructTreeFromArray(nums, left, middle - 1);
        node.right = constructTreeFromArray(nums, middle + 1, right);

        return node;
    }
}
