/*
 * @lc app=leetcode.cn id=145 lang=java
 *
 * [145] 二叉树的后序遍历
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

    public List<Integer> postorderTraversal(TreeNode root) {
        traversal(root);
        return res;
    }

    private void traversal(TreeNode node) {
        if (node == null) {
            return;
        }
        
        traversal(node.left);
        traversal(node.right);

        // 后序遍历
        res.add(node.val);
    }
}
// @lc code=end

