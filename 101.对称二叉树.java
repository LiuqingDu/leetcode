/*
 * @lc app=leetcode.cn id=101 lang=java
 *
 * [101] 对称二叉树
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
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        return dfs(root.left, root.right);
    }

    private boolean dfs(TreeNode left, TreeNode right) {
        // 如果两边都是空则对称
        if (left == null && right == null) {
            return true;
        }
        // 如果只有一边为空则不对称
        if (left == null || right == null) {
            return false;
        }
        // 如果数值不同则不对称
        if (left.val != right.val) {
            return false;
        }
        // 递归比较左边的左节点和右边的右节点，以及左边的右节点和右边的左节点
        return dfs(left.left, right.right) && dfs(left.right, right.left);
    }
}
// @lc code=end

