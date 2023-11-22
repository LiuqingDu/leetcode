/*
 * @lc app=leetcode.cn id=230 lang=javascript
 *
 * [230] 二叉搜索树中第K小的元素
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
 * @param {number} k
 * @return {number}
 */
var kthSmallest = function(root, k) {

    let res = 0;
    let n = 0;

    let traversal = function(node, k) {
        if (!node) {
            return;
        }
        
        traversal(node.left, k);

        n++;
        if (n === k) {
            res = node.val;
            return;
        }

        traversal(node.right, k);
    }

    traversal(root, k);
    return res;

};
// @lc code=end

