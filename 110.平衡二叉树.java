/*
 * @lc app=leetcode.cn id=110 lang=java
 *
 * [110] 平衡二叉树
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
    // 平衡二叉树是指每个节点的左右子树高度差不超过1
    // 可以从顶部往下依次计算每个子树的高度差，比价所有的节点的左右子树高度差
    // 但这样会有重复计算，因为子树的高度取决于这个子树的下面两个孙子树的高度，
    // 然后遍历到这个子节点的时候，孙子树的高度又要被计算一次
    // 因此从底部往上计算，从底开始判断就需要从叶子节点的两个null子节点开始，
    // 如果是null节点，返回高度为0
    // 对于其他节点，根据左右子树的高度来比较是否高度差超过1，
    // 如果超过1，直接返回-1表示这里已经不平衡了，那么整棵树就不是平衡的
    // 如果没超过1，则计算当前高度并返回
    // 最终判断根节点的高度是不是-1就可以
    public boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }

    // 计算一个节点的高度，-1表示这个节点这里已经不是平衡树了
    private int height(TreeNode node) {
        // 如果是最底部的null节点，那么高度就是0
        if (node == null) {
            return 0;
        }
        int left, right;
        // 注意这里并没有先分别计算左右子树的高度，而是在或语句里依次计算
        // 好处是如果左子树已经不是平衡树了，那么可以跳过计算右子树而直接返回-1
        // 效率更高一些
        if ((left = height(node.left)) == -1 || (right = height(node.right)) == -1 || Math.abs(left - right) > 1) {
            return -1;
        }
        // 返回当前节点高度
        return Math.max(left, right) + 1;
    }
}
// @lc code=end

