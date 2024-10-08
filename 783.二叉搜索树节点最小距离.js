/*
 * @lc app=leetcode.cn id=783 lang=javascript
 *
 * [783] 二叉搜索树节点最小距离
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
var minDiffInBST = function(root) {
    let pre = null;
    let res = Number.MAX_VALUE;
    let inOrder = function(node) {
        if (!node) {
            return;
        }

        inOrder(node.left);
        
        if (pre === null) {
            pre = node.val;
        } else {
            res = Math.min(res, node.val - pre);
            pre = node.val;
        }

        inOrder(node.right);
    }

    inOrder(root);
    return res;
};
// @lc code=end

