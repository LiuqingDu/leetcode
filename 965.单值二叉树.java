/*
 * @lc app=leetcode.cn id=965 lang=java
 *
 * [965] 单值二叉树
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
    private int n;
    public boolean isUnivalTree(TreeNode root) {
        n = root.val;
        return traversal(root);
    }

    private boolean traversal(TreeNode node) {
        if (node == null) {
            return true;
        }

        if (node.val != n) {
            return false;
        }

        return traversal(node.left) && traversal(node.right);
    }
}
// @lc code=end

