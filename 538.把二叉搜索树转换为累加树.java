/*
 * @lc app=leetcode.cn id=538 lang=java
 *
 * [538] 把二叉搜索树转换为累加树
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

    // 从最右边的节点开始往左累加和，把和更新到节点上即可
    // 遍历顺序为右-中-左
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        travesal(root);
        return root;
    }

    private void travesal(TreeNode node) {
        if (node == null) {
            return;
        }

        travesal(node.right);
        sum += node.val;
        node.val = sum;
        travesal(node.left);
        return;
    }
}
// @lc code=end

