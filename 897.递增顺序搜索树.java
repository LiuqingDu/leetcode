/*
 * @lc app=leetcode.cn id=897 lang=java
 *
 * [897] 递增顺序搜索树
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
    TreeNode dummy = new TreeNode();
    TreeNode current = dummy;
    public TreeNode increasingBST(TreeNode root) {
        inorderTraversal(root);
        return dummy.right;
    }

    private void inorderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }

        inorderTraversal(node.left);

        // 为避免循环引用，先把左节点清空
        node.left = null;
        current.right = node;
        current = current.right;

        inorderTraversal(node.right);
    }
}
// @lc code=end

