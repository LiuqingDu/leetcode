/*
 * @lc app=leetcode.cn id=671 lang=javascript
 *
 * [671] 二叉树中第二小的节点
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
var findSecondMinimumValue = function(root) {
    if (!root || !root.left) {
        return -1;
    }
    let left = root.val == root.left.val ?
                findSecondMinimumValue(root.left) :
                root.left.val;
    let right = root.val == root.right.val ?
                findSecondMinimumValue(root.right) :
                root.right.val;
    let min = Math.min(left, right);
    return min > 0 ? min : Math.max(left, right);
};
// @lc code=end

