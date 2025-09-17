/*
 * @lc app=leetcode.cn id=2236 lang=java
 *
 * [2236] 判断根结点是否等于子结点之和
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
    public boolean checkTree(TreeNode root) {
        if (root == null) {
            return false;
        }
        int leftVal = root.left != null ? root.left.val : 0;
        int rightVal = root.right != null ? root.right.val : 0;
        return root.val == leftVal + rightVal;
    }
}
// @lc code=end

