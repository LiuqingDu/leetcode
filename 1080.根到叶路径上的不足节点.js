/*
 * @lc app=leetcode.cn id=1080 lang=javascript
 *
 * [1080] 根到叶路径上的不足节点
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
 * @param {number} limit
 * @return {TreeNode}
 */
var sufficientSubset = function(root, limit) {
    
    const haveSufficient = checkSufficientLeaf(root, 0, limit);
    return haveSufficient ? root : null;
};

var checkSufficientLeaf = function(node, sum, limit) {
    if (node == null) {
        return false;
    }
    if (node.left == null && node.right == null) {
        return node.val + sum >= limit;
    }
    const haveSufficientLeft = checkSufficientLeaf(node.left, sum + node.val, limit);
    const haveSufficientRight = checkSufficientLeaf(node.right, sum + node.val, limit);
    if (!haveSufficientLeft) {
        node.left = null;
    }
    if (!haveSufficientRight) {
        node.right = null;
    }
    return haveSufficientLeft || haveSufficientRight;
};

// @lc code=end

