/*
 * @lc app=leetcode.cn id=501 lang=javascript
 *
 * [501] 二叉搜索树中的众数
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
 * @return {number[]}
 */
var findMode = function(root) {
    let res = [];
    let curCount = 0;
    let maxCount = 0;
    let pre = null;

    let inOrder = function(node) {
        if (!node) {
            return;
        }

        inOrder(node.left);

        if (pre && pre.val == node.val) {
            curCount++;
        } else {
            curCount = 1;
        }

        if (curCount > maxCount) {
            res = [node.val];
            maxCount = curCount;
        } else if (curCount === maxCount) {
            res.push(node.val);
        }

        pre = node;

        inOrder(node.right);
    }

    inOrder(root);
    return res;

};
// @lc code=end

