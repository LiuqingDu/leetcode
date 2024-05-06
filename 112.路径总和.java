/*
 * @lc app=leetcode.cn id=112 lang=java
 *
 * [112] 路径总和
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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        // 这道题明显的思路是dfs计算从根到叶子节点的和
        // 还可以用递归的方式解决，比较简单
        // 关键是定义方法的意思为，以当前节点为根，这棵树的一条路径和是否为target
        // 如果这个根节点已经是叶子节点，
        // 那么只要比较target和根节点的val是否相等就可以了
        // 如果不是叶子节点，那么就需要看两个子树的和能否为target-val
        // 这样就把问题拆解为子树的问题
        
        if (root == null) {
            return false;
        }

        // 如果是叶子节点就直接比较
        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }

        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);

    }
}
// @lc code=end

