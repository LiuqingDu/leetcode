/*
 * @lc app=leetcode.cn id=129 lang=java
 *
 * [129] 求根节点到叶节点数字之和
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

    private int sum = 0;

    public int sumNumbers(TreeNode root) {

        dfs(root, 0);

        return sum;
    }

    private void dfs(TreeNode node, int number) {
        number = number * 10 + node.val;

        if (node.left == null && node.right == null) {
            sum += number;
            number = number / 10;
            return;
        }

        if (node.left != null) {
            dfs(node.left, number);
        }

        if (node.right != null) {
            dfs(node.right, number);
        }

    }
}
// @lc code=end

