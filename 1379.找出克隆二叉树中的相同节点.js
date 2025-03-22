/*
 * @lc app=leetcode.cn id=1379 lang=javascript
 *
 * [1379] 找出克隆二叉树中的相同节点
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} original
 * @param {TreeNode} cloned
 * @param {TreeNode} target
 * @return {TreeNode}
 */

var getTargetCopy = function(original, cloned, target) {
    if (original == null) {
        return null;
    }
    if (original == target) {
        return cloned;
    }
    const left = getTargetCopy(original.left, cloned.left, target);
    if (left != null) {
        return left;
    }
    return getTargetCopy(original.right, cloned.right, target);
};
// @lc code=end

