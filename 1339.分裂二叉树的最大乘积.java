/*
 * @lc app=leetcode.cn id=1339 lang=java
 *
 * [1339] 分裂二叉树的最大乘积
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

    long max = 0;
    long total = 0;
    int MOD = 1000000007;

    public int maxProduct(TreeNode root) {

        // 1. 先求整棵树总和
        total = getSum(root);

        // 2. 再次遍历，计算最大乘积
        dfs(root);

        return (int)(max % MOD);
    }

    // 求整棵树总和
    private long getSum(TreeNode root) {

        if (root == null) {
            return 0;
        }

        return root.val + getSum(root.left) + getSum(root.right);
    }

    // 后序遍历求子树和
    private long dfs(TreeNode root) {

        if (root == null) {
            return 0;
        }

        // 左子树和
        long left = dfs(root.left);

        // 右子树和
        long right = dfs(root.right);

        // 当前子树总和
        long sum = root.val + left + right;

        // 删除当前节点与父节点的边
        // 得到两部分：
        // sum 和 total-sum
        long product = sum * (total - sum);

        // 更新最大值
        max = Math.max(max, product);

        return sum;
    }
}
// @lc code=end

