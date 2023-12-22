/*
 * @lc app=leetcode.cn id=543 lang=javascript
 *
 * [543] 二叉树的直径
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
 * @return {number}
 */
var diameterOfBinaryTree = function(root) {

    let res = 0;

    let maxDepth = function(node) {
        if (!node) {
            return 0;
        }

        let left = maxDepth(node.left);
        let right = maxDepth(node.right);

        res = Math.max(res, left + right);

        return Math.max(left, right) + 1;
    }

    maxDepth(root);

    return res;
};
// @lc code=end

