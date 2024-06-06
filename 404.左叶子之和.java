/*
 * @lc app=leetcode.cn id=404 lang=java
 *
 * [404] 左叶子之和
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
    public int sumOfLeftLeaves(TreeNode root) {
        return sumIfLeft(root, false);
    }

    private int sumIfLeft(TreeNode node, boolean left) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            if (left) {
                return node.val;
            } else {
                return 0;
            }
        }
        return sumIfLeft(node.left, true) + sumIfLeft(node.right, false);
    }
}
// @lc code=end

