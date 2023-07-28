/*
 * @lc app=leetcode.cn id=226 lang=java
 *
 * [226] 翻转二叉树
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
    public TreeNode invertTree(TreeNode root) {
        inverse(root);
        return root;
    }

    // 依次交换左右节点
    private void inverse(TreeNode node) {
        if (node == null) {
            return;
        }
        TreeNode temp = node.right;
        node.right = node.left;
        node.left = temp;

        inverse(node.left);
        inverse(node.right);
    }
}
// @lc code=end

