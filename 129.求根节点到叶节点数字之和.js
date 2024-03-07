/*
 * @lc app=leetcode.cn id=129 lang=javascript
 *
 * [129] 求根节点到叶节点数字之和
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
var sumNumbers = function(root) {

    let sum = 0;

    let dfs = function(node, number) {
        number = number * 10 + node.val;

        if (!node.left && !node.right) {
            sum += number;
            number = parseInt(number / 10);
            return;
        }

        if (node.left) {
            dfs(node.left, number);
        }

        if (node.right) {
            dfs(node.right, number);
        }
    }

    dfs(root, 0);

    return sum;

};
// @lc code=end

