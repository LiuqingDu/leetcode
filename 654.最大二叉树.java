/*
 * @lc app=leetcode.cn id=654 lang=java
 *
 * [654] 最大二叉树
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    // 遍历找到最大值，分割为左右两部分，然后递归继续建立左右子树

    private TreeNode build(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int max = Integer.MIN_VALUE;
        int index = 0;

        for (int i = left; i <= right; i++) {
            if (nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }

        TreeNode node = new TreeNode();
        node.val = max;
        node.left = build(nums, left, index - 1);
        node.right = build(nums, index + 1, right);
        return node;
    }
}
// @lc code=end

