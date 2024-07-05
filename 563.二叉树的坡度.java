/*
 * @lc app=leetcode.cn id=563 lang=java
 *
 * [563] 二叉树的坡度
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
    int res = 0;
    public int findTilt(TreeNode root) {
        // 明显要遍历每一个节点，对于每一个节点，需要知道它的左子树之和，以及右子树之和
        // 两个子树和的差值就是坡度，用一个全局变量存储坡度之和即可
        // 对于子树之和，用dfs即可
        dfs(root);
        return res;
    }

    // 计算一个子树的和
    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        // 分别获得左右子树的和
        int l = dfs(node.left);
        int r = dfs(node.right);
        // 把坡度累加到结果中
        res += Math.abs(l - r);
        // 返回子树和
        return node.val + l + r;
    }
}
// @lc code=end

