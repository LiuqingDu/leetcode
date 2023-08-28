/*
 * @lc app=leetcode.cn id=450 lang=java
 *
 * [450] 删除二叉搜索树中的节点
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
    // 删除也是需要先找到节点，递归更新子树，并替换原有子树
    public TreeNode deleteNode(TreeNode root, int key) {

        if (root == null) {
            return null;
        }

        // 如果找到了则开始删除
        if (root.val == key) {
            // 如果左右子树都为空，也就是当前节点是叶子节点，直接返回空节点就可以
            // 实际上这句可以不要，因为再下面两个if已经包含这个情况了
            if (root.left == null && root.right == null) {
                return null;
            }
            // 如果左右子树有一个为空，则用存在的子树替换当前节点即可
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            // 最后的情况就是左右子树都存在，这时候需要左子树最大的数字或者右子树最小的数字来替换当前节点。
            // 这里用右子树最小值来替换当前节点
            // 查找右子树最小节点
            TreeNode min = getMin(root.right);
            // 用最小节点替换当前节点的值
            root.val = min.val;
            // 在右子树把最小节点删掉
            root.right = deleteNode(root.right, min.val);
        }

        // 如果在左边则去左子树删除并更新左子树
        else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        }

        // 如果在右边则去右子树删除，并更新右子树
        else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        }
        return root;
    }

    // 获取一棵子树的最小节点
    private TreeNode getMin(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}
// @lc code=end

