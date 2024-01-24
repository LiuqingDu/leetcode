/*
 * @lc app=leetcode.cn id=1038 lang=javascript
 *
 * [1038] 从二叉搜索树到更大和树
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
 * @return {TreeNode}
 */
var bstToGst = function(root) {

    let sum = 0;

    let traversal = function(node) {
        if (!node) {
            return;
        }

        traversal(node.right);
        sum += node.val;
        node.val = sum;
        traversal(node.left);
        
        return node;
    }

    return traversal(root);
};
// @lc code=end

