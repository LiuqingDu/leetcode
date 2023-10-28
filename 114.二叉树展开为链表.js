/*
 * @lc app=leetcode.cn id=114 lang=javascript
 *
 * [114] 二叉树展开为链表
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @return {void} Do not return anything, modify root in-place instead.
 */
var flatten = function(root) {

    let dump = new TreeNode();

    let traversal = function(node) {
        if (!node) {
            return;
        }
        traversal(node.right);
        traversal(node.left);
        let tmp = dump.right;
        node.right = tmp;
        node.left = null;
        dump.right = node;
    }

    traversal(root);
};
// @lc code=end

