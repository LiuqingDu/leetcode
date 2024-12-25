/*
 * @lc app=leetcode.cn id=606 lang=java
 *
 * [606] 根据二叉树创建字符串
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
    public String tree2str(TreeNode root) {
        // 如果节点只有左子树，需要显示左子树结果（用括号包裹），但不要显示空的右子树。
        // 如果节点有右子树，则需要同时显示左右子树的结果（右子树和左子树都用括号包裹）。
        // 如果节点没有子树，不需要显示括号。
        
        // 如果节点为空，直接返回空字符串
        if (root == null) {
            return "";
        }
        
        // 把当前节点的值转成字符串
        String result = String.valueOf(root.val);
        
        // 处理左子树
        if (root.left != null) {
            result += "(" + tree2str(root.left) + ")";
        } else if (root.right != null) {
            // 如果左子树为空但右子树不为空，必须显示一对空括号
            result += "()";
        }
        
        // 处理右子树
        if (root.right != null) {
            result += "(" + tree2str(root.right) + ")";
        }
        
        return result;
    }
}
// @lc code=end

