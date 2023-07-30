/*
 * @lc app=leetcode.cn id=543 lang=java
 *
 * [543] 二叉树的直径
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
    int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        // 最长的直径就是左节点下面最大深度+右节点下的最大深度
        // 使用计算深度的方法，在途中随时更新最大直径
        maxDepth(root);
        return maxDiameter;
    }

    private int maxDepth(TreeNode node) {
        // 空节点深度为0
        if (node == null) {
            return 0;
        }
        // 计算左右子节点的深度
        int leftDepth = maxDepth(node.left);
        int rightDepth = maxDepth(node.right);
        // 在计算深度的过程中更新最大直径
        // 当前直径是左右深度之和，再更新最大直径
        maxDiameter = Math.max(maxDiameter, leftDepth + rightDepth);
        // 返回当前节点深度，为左右深度最大值再+1
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
// @lc code=end

