/*
 * @lc app=leetcode.cn id=337 lang=java
 *
 * [337] 打家劫舍 III
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
    public int rob(TreeNode root) {
        int[] res = robNode(root);
        return Math.max(res[0], res[1]);
    }

    private int[] robNode(TreeNode node) {
        if (node == null) {
            return new int[]{0, 0};
        }

        int[] res = new int[]{0, 0};

        int[] left = robNode(node.left);
        int[] right = robNode(node.right);

        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        res[1] = left[0] + right[0] + node.val;

        return res;
    }
}
// @lc code=end

