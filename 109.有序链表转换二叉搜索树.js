/*
 * @lc app=leetcode.cn id=109 lang=javascript
 *
 * [109] 有序链表转换二叉搜索树
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
 * @return {TreeNode}
 */
var sortedListToBST = function(head) {

    if (!head) {
        return null;
    }

    let c = 0;
    let p = head;
    while (p) {
        c++;
        p = p.next;
    }

    let cur = head;

    let buildTree = function(start, end) {
        if (start > end) {
            return null;
        }

        let mid = Math.floor((start + end) / 2);

        let left = buildTree(start, mid - 1);

        let node = new TreeNode();
        node.val = cur.val;
        cur = cur.next;

        let right = buildTree(mid + 1, end);

        node.right = right;
        node.left = left;

        return node;
    }

    return buildTree(0, c - 1);

};
// @lc code=end

