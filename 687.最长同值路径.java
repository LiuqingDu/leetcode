/*
 * @lc app=leetcode.cn id=687 lang=java
 *
 * [687] 最长同值路径
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
    // 用于记录全局最长同值路径（边数）
    int maxPath = 0;

    public int longestUnivaluePath(TreeNode root) {
        if (root == null) return 0;
        dfs(root);
        return maxPath;
    }

    // 递归函数：返回以 node 为起点，向下延伸的相同节点值的最大边数
    private int dfs(TreeNode node) {
        if (node == null) return 0;

        // 1. 先去问问左右子树：你们各自向下最长能延伸多少？
        int leftLen = dfs(node.left);
        int rightLen = dfs(node.right);

        // 2. 看看左/右子树能不能和当前的 node 连起来
        int arrowLeft = 0, arrowRight = 0;
        
        // 如果左子树存在，且值和当前节点相同，说明左边能连上
        if (node.left != null && node.left.val == node.val) {
            arrowLeft = leftLen + 1; // 边数加 1
        }
        
        // 如果右子树存在，且值和当前节点相同，说明右边能连上
        if (node.right != null && node.right.val == node.val) {
            arrowRight = rightLen + 1; // 边数加 1
        }

        // 3. 核心：尝试用“左边同值边数 + 右边同值边数”去挑战全局最大值
        maxPath = Math.max(maxPath, arrowLeft + arrowRight);

        // 4. 向上汇报：父节点只能选择左或右其中一条路走下去，所以返回较大的一侧
        return Math.max(arrowLeft, arrowRight);
    }
}
// @lc code=end

