/*
 * @lc app=leetcode.cn id=2236 lang=javascript
 *
 * [2236] 判断根结点是否等于子结点之和
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
 * @return {boolean}
 */
var checkTree = function(root) {
    if (root === null) {
        return false;
    }
    const leftVal = root.left !== null ? root.left.val : 0;
    const rightVal = root.right !== null ? root.right.val : 0;
    return root.val === leftVal + rightVal;
};
// @lc code=end

