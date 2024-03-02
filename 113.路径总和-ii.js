/*
 * @lc app=leetcode.cn id=113 lang=javascript
 *
 * [113] 路径总和 II
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
 * @param {number} targetSum
 * @return {number[][]}
 */
var pathSum = function(root, targetSum) {

    let res = [];

    let backtrack = function(node, path, sum, target) {
        if (!node) {
            return;
        }

        path.push(node.val);
        sum += node.val;

        if (sum === target && !node.left && !node.right) {
            res.push([...path])
        }

        backtrack(node.left, path, sum, target);
        backtrack(node.right, path, sum, target);

        sum -= node.val;
        path.pop();
    }

    backtrack(root, [], 0, targetSum);

    return res;

};
// @lc code=end

