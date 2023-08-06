/*
 * @lc app=leetcode.cn id=230 lang=java
 *
 * [230] 二叉搜索树中第K小的元素
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
    // 二叉搜索树特点是左边比根节点小，右边比根节点大
    // 中序遍历的结果就是把二叉树从小到大遍历一下
    // 找到中序遍历的第k个元素就是结果

    // 记录结果
    int res = 0;
    // 记录当前的序号
    int index = 0;

    public int kthSmallest(TreeNode root, int k) {
        traverse(root, k);
        return res;
    }

    private void traverse(TreeNode node, int k) {
        if (node == null) {
            return;
        }
    
        traverse(node.left, k);
        // 中序遍历
        index++;
        if (index == k) {
            res = node.val;
            return;
        }
        traverse(node.right, k);
    }
 }
// @lc code=end

