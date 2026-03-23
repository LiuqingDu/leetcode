/*
 * @lc app=leetcode.cn id=1367 lang=java
 *
 * [1367] 二叉树中的链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    public boolean isSubPath(ListNode head, TreeNode root) {
        
        if (root == null) {
            return false;
        }
        return dfs(root, head) || isSubPath(head, root.left) || isSubPath(head, root.right);
    }

    public boolean dfs(TreeNode rt, ListNode head) {
        // 链表已经全部匹配完，匹配成功
        if (head == null) {
            return true;
        }
        // 二叉树访问到了空节点，匹配失败
        if (rt == null) {
            return false;
        }
        // 当前匹配的二叉树上节点的值与链表节点的值不相等，匹配失败
        if (rt.val != head.val) {
            return false;
        }
        return dfs(rt.left, head.next) || dfs(rt.right, head.next);
    }
}
// @lc code=end

