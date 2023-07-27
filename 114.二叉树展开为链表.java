/*
 * @lc app=leetcode.cn id=114 lang=java
 *
 * [114] 二叉树展开为链表
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
    private TreeNode pre = null;

    public void flatten(TreeNode root) {
        traversal(root);
    }

    // 看图可知，需要的顺序是中序，即 中-左-右
    // 但如果按照中序遍历，按照逻辑需要把当前节点置为前一个节点的右节点
    // 此时前一个结点的右节点还没有遍历，因此会造成错误
    // 如果按照 右-左-中 的顺序遍历则不会影响
    // 从右下角开始倒着遍历，每次把前节点置为当前节点的右节点，
    // 此时右节点是最先遍历的，修改右节点不影响

    private void traversal(TreeNode node) {
        if (node == null) {
            return;
        }

        traversal(node.right);
        traversal(node.left);

        // 如果是第一个节点则记录为前节点
        if (pre == null) {
            pre = node;
        } else {
            // 把之前的节点放在右节点上
            node.right = pre;
            node.left = null;
            pre = node;
        }
    }
}
// @lc code=end

