/*
 * @lc app=leetcode.cn id=814 lang=java
 *
 * [814] 二叉树剪枝
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
    public TreeNode pruneTree(TreeNode root) {
        // 如果一个节点及子树没有1, 则需要剪掉这个节点, 用null表示
        // 如果一个节点的值为0，并且它的左右子树都为空，则需要剪掉这个节点
        // 如果节点为1, 或者它至少有一个子节点含有1，则保留这个节点

        // 如果根节点为空，直接返回空
        if (root == null) {
            return null;
        }
        // 递归修剪左子树和右子树
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        // 如果当前节点的值为0，并且它的左右子树都为空，则
        if (root.val == 0 && root.left == null && root.right == null) {
            return null; // 返回空，表示剪枝
        }
        // 否则，返回当前节点
        return root;
    }
}
// @lc code=end

