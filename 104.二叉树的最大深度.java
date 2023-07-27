/*
 * @lc app=leetcode.cn id=104 lang=java
 *
 * [104] 二叉树的最大深度
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
    private int max = 0;

    // 依次遍历每个节点，当节点不为空，层数+1并更新最大深度
    // 离开节点的时候层数-1
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root != null) {
            depth++;
            max = Math.max(max, depth);
            maxDepth(root.left);
            maxDepth(root.right);
            depth--;
        }
        return max;
    }
}
// @lc code=end

