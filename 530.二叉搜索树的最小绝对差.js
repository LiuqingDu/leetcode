/*
 * @lc app=leetcode.cn id=530 lang=javascript
 *
 * [530] 二叉搜索树的最小绝对差
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
var getMinimumDifference = function(root) {
    let pre = null;
    let res = Number.MAX_VALUE;
    let inOrder = function(node) {
        if (!node) {
            return;
        }
        inOrder(node.left);
        // pre 可以等于0，所以这里不能判断if(!pre),要跟null比较
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

