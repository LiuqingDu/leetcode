/*
 * @lc app=leetcode.cn id=1038 lang=java
 *
 * [1038] 从二叉搜索树到更大和树
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

    // 看图可知，实际上是从最右下角的节点开始累加，
    // 先右节点，再自己，再左节点，依次加上自己的 val
    // 也就是说，自己节点的值等于自己加上右节点
    // 左节点的值等于左节点加上自己的值，
    // 父节点等于它加上左节点的值
    // 可以按照右、自己、左的顺序遍历
    // 然后维护一个变量用来累加

    public TreeNode bstToGst(TreeNode root) {
        traverse(root);
        return root;
    }

    private int sum = 0;

    private void traverse(TreeNode node) {
        if (node == null) {
            return;
        }
        // 先遍历右节点，遍历完会更新 sum
        traverse(node.right);
        // 自己是 sum 加上自己
        node.val += sum;
        // 更新 sum
        sum = node.val;
        // 再遍历左节点，左节点会在 sum 基础上继续累加
        traverse(node.left);
    }
}
// @lc code=end

