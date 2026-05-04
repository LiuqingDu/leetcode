/*
 * @lc app=leetcode.cn id=1315 lang=java
 *
 * [1315] 祖父节点值为偶数的节点和
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
    int sum = 0;

    public int sumEvenGrandparent(TreeNode root) {
        dfs(root, null, null);
        return sum;
    }

    private void dfs(TreeNode node, TreeNode parent, TreeNode grandParent) {
        if (node == null) return;

        // 如果祖父节点存在且是偶数
        if (grandParent != null && grandParent.val % 2 == 0) {
            sum += node.val;
        }

        // 继续向下遍历
        dfs(node.left, node, parent);
        dfs(node.right, node, parent);
    }
}
// @lc code=end

