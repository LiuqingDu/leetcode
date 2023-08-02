/*
 * @lc app=leetcode.cn id=222 lang=java
 *
 * [222] 完全二叉树的节点个数
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

    // 一般解法，递归计算子节点数目
    // public int countNodes(TreeNode root) {
    //     if (root == null) {
    //         return 0;
    //     }
    //     return countNodes(root.left) + countNodes(root.right) + 1;
    // }

    
    // 解法二
    // 完全二叉树的特性：根节点的左右子树，必定有一个是满二叉树，
    // 另一个可能是满二叉树也可能是完全二叉树
    // 满二叉树的节点数为 (2^n)-1，n为层数，根节点层数为1
    // 这样在递归中判断两侧哪个是满二叉树即可更快计算出节点数，
    // 不需要遍历每一个节点，只需要遍历一侧计算高度即可
    // 比较左子树的左侧高度和右子树的左侧高度即可知道哪个子树是满二叉树
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        // 计算高度
        int hL = 0, hR = 0;
        TreeNode left = root.left;
        TreeNode right = root.right;
        // 注意左右子树都是计算它们的左侧高度
        while(left != null) {
            hL++;
            left = left.left;
        }
        while(right != null) {
            hR++;
            right = right.left;
        }
        // 如果这两个值相等，说明左边是满二叉树
        if (hL == hR) {
            // 满二叉树 + 完全二叉树 + 自己1
            return (int) Math.pow(2, hL) - 1 + countNodes(root.right) + 1;
        } else {
            // 否则右边是满二叉树
            return (int) Math.pow(2, hR) - 1 + countNodes(root.left) + 1;
        }
        
    }

}
// @lc code=end

