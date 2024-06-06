/*
 * @lc app=leetcode.cn id=404 lang=javascript
 *
 * [404] 左叶子之和
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
var sumOfLeftLeaves = function(root) {
    let sumIfLeft = function(node, isLeft) {
        if (!node) {
            return 0;
        }
        if (!node.left && !node.right) {
            if (isLeft) {
                return node.val;
            } else {
                return 0;
            }
        }
        return sumIfLeft(node.left, true) + sumIfLeft(node.right, false);
    }

    return sumIfLeft(root, false);

};
// @lc code=end

