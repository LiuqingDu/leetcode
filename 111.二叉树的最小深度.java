/*
 * @lc app=leetcode.cn id=111 lang=java
 *
 * [111] 二叉树的最小深度
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
    private int depth = 0;
    private int min = 0;

    public int minDepth(TreeNode root) {
        min(root);
        return min;
    }

    // 依次遍历节点，如果节点没有左右节点，则更新最小高度
    private void min(TreeNode node) {
        if (node == null) {
            return;
        }
        depth++;
        if (node.left == null && node.right == null) {
            // 如果min是初始值则先更新一下
            if (min == 0) {
                min = depth;
            } else {
                // 如果不是初始值则比较
                min = Math.min(min, depth);
            }
        }
        min(node.left);
        min(node.right);
        depth--;
    }
}
// @lc code=end

