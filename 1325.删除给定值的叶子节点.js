/*
 * @lc app=leetcode.cn id=1325 lang=javascript
 *
 * [1325] 删除给定值的叶子节点
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
 * @param {number} target
 * @return {TreeNode}
 */
var removeLeafNodes = function(root, target) {
    if (root === null) return null;

    // 先处理左右子树（后序）
    root.left = removeLeafNodes(root.left, target);
    root.right = removeLeafNodes(root.right, target);

    // 如果当前节点变成叶子节点，并且值等于 target，就删除
    if (root.left === null && root.right === null && root.val === target) {
        return null;
    }

    return root;
};
// @lc code=end

