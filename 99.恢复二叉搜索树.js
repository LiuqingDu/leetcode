/*
 * @lc app=leetcode.cn id=99 lang=javascript
 *
 * [99] 恢复二叉搜索树
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
var recoverTree = function(root) {
    let a = null;
    let b = null;
    let pre = null;

    let dfs = function(node) {
        if (!node) {
            return;
        }

        dfs(node.left);

        if (pre && pre.val > node.val) {
            if (!a) {
                a = pre;
            }
            b = node;
        }
        pre = node;

        dfs(node.right)
    }

    dfs(root);

    if (a && b) {
        let tmp = a.val;
        a.val = b.val;
        b.val = tmp;
    }
};
// @lc code=end

