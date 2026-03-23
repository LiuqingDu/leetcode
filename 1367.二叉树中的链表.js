/*
 * @lc app=leetcode.cn id=1367 lang=javascript
 *
 * [1367] 二叉树中的链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {ListNode} head
 * @param {TreeNode} root
 * @return {boolean}
 */
var isSubPath = function(head, root) {
    var dfs = function(rt, head) {
        if (head == null) return true;
        if (rt == null) return false;
        if (rt.val != head.val) return false;
        return dfs(rt.left, head.next) || dfs(rt.right, head.next);
    }
    
    if (root == null) return 0;
    return dfs(root, head) || isSubPath(head, root.left) || isSubPath(head, root.right);
};
// @lc code=end

