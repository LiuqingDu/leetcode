/*
 * @lc app=leetcode.cn id=1457 lang=java
 *
 * [1457] 二叉树中的伪回文路径
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
    // 记录最终的伪回文路径数量
    private int count = 0;
    
    public int pseudoPalindromicPaths (TreeNode root) {
        dfs(root, 0);
        return count;
    }

    private void dfs(TreeNode node, int path) {
        if (node == null) {
            return;
        }

        // 1. 把当前节点的值，对应到二进制的某一位，并取反（0变1，1变0）
        path ^= (1 << node.val);

        // 2. 如果碰到了叶子节点，说明一条路径走完了，开始检查
        if (node.left == null && node.right == null) {
            // (path & (path - 1)) == 0 是一种高效判断二进制中 1 的个数是否 <= 1 的方法
            if ((path & (path - 1)) == 0) {
                count++;
            }
            return;
        }

        // 3. 继续往左、往右递归（因为 path 是值传递，回溯时不需要手动恢复）
        dfs(node.left, path);
        dfs(node.right, path);
    }
}
// @lc code=end

