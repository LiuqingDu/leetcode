/*
 * @lc app=leetcode.cn id=144 lang=java
 *
 * [144] 二叉树的前序遍历
 */

// @lc code=start

import java.util.List;

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
    List<Integer> res = new LinkedList<Integer>();

    public List<Integer> preorderTraversal(TreeNode root) {
        traversal(root);
        return res;
    }

    private void traversal(TreeNode node) {
        // 前序遍历
        if (node == null) {
            return;
        }

        res.add(node.val);

        traversal(node.left);
        traversal(node.right);
    }
}
// @lc code=end

