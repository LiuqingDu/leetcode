/*
 * @lc app=leetcode.cn id=572 lang=java
 *
 * [572] 另一棵树的子树
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
    // 明显要涉及递归
    // 既然涉及比较两棵树的结构，可以想到需要一个递归判断两棵树是否完全相同，
    // 题目中要判断是否为子树，其实两棵树完全相同的情况就是题目中子树的一种特殊情况
    // 对于题目中的情况，要么这两棵树一样，要么第二棵树跟第一棵树的一个子树一样
    // 那么可以看出需要在判断两棵树相同的基础上，再递归判断第一棵的的子树是不是跟第二棵树一样
    // 因此需要两个递归，
    // 一个用来判断两棵树是否完全一样，另一个用来遍历第一棵树的每个节点，
    // 看这个节点形成的子树是否跟第二个树一样

    // 判断第一颗树是否有一部分跟第二棵一样
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        // 第二棵树为空，则是子树
        if (subRoot == null) {
            return true;
        }
        // 此时第二棵不为空，如果第一颗为空，则false
        if (root == null) {
            return false;
        }
        // 要么两棵树一样，要么第一棵树的左右子树里有一部分跟第二棵一样
        return isSameTree(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    // 判断两棵树是否一样
    private boolean isSameTree(TreeNode node1, TreeNode node2) {
        // 两棵全为空则true
        if (node1 == null && node2 == null) {
            return true;
        }
        // 此时两棵树不全为空，如果其中一个为空，则false
        if (node1 == null || node2 == null) {
            return false;
        }
        // 此时两棵均不为空，如果值不同则false
        if (node1.val != node2.val) {
            return false;
        }
        // 此时当前节点相同，继续判断左右节点
        return isSameTree(node1.left, node2.left) && isSameTree(node1.right, node2.right);
    }
}
// @lc code=end

