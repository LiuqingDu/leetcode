/*
 * @lc app=leetcode.cn id=1372 lang=java
 *
 * [1372] 二叉树中的最长交错路径
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
    // 记录最大长度
    int ans = 0;

    public int longestZigZag(TreeNode root) {

        // 从 root 开始
        // 假设第一步往左
        dfs(root.left, 1, true);

        // 假设第一步往右
        dfs(root.right, 1, false);

        return ans;
    }

    /**
     * @param node 当前节点
     * @param len  当前交错长度
     * @param isLeft 上一步是否往左
     */
    public void dfs(TreeNode node, int len, boolean isLeft) {

        // 到空节点结束
        if (node == null) {
            return;
        }

        // 更新答案
        ans = Math.max(ans, len);

        // 如果上一步往左
        if (isLeft) {

            // 下一步往右：交错成功
            dfs(node.right, len + 1, false);

            // 下一步继续往左：重新开始
            dfs(node.left, 1, true);

        } else {

            // 上一步往右

            // 下一步往左：交错成功
            dfs(node.left, len + 1, true);

            // 下一步继续往右：重新开始
            dfs(node.right, 1, false);
        }
    }
}
// @lc code=end

