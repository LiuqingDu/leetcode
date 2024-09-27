/*
 * @lc app=leetcode.cn id=99 lang=java
 *
 * [99] 恢复二叉搜索树
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
    TreeNode a = null;
    TreeNode b = null;
    TreeNode pre = null;

    public void recoverTree(TreeNode root) {
        // 二叉搜索树的中序遍历是一个递增的序列
        // 假设原序列是[1,2,3,4,5]
        // 其中两个元素交换了位置，那么可能有两种：
        // 1. 相邻两个元素交换
        //    [1,3,2,4,5]
        //    此时遍历此序列会遇到一次递减，在 3 和 2 处
        //    它们分别是需要交换的第一个元素和第二个元素
        // 2. 不相邻的两个元素交换
        //    [1,5,3,4,2]
        //    此时遍历会出现两次递减，在 5,3 和 4,2 处
        //    第一次的第一个元素，和第二次的第二个元素是需要交换的元素
        // 合并一下情况，当第一次遇到下降的时候，记住两个元素
        // 后续再遇到下降的时候，替换并记住第二个元素
        // 替换记住的两个元素
        
        dfs(root);
        if (a != null && b != null) {
            int tmp = a.val;
            a.val = b.val;
            b.val = tmp;
        }
    }

    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }

        dfs(node.left);

        // 如果前一个节点的值比当前节点大，说明遇到了下降
        // 如果是第一次，就记录第一个节点
        // 无论第几次，都记录第二个节点
        if (pre != null && pre.val > node.val) {
            if (a == null) {
                a = pre;
            }

            b = node;
        }
        // 当前节点为上一个节点
        pre = node;

        dfs(node.right);
    }
}
// @lc code=end

