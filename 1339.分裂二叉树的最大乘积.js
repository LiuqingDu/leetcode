/*
 * @lc app=leetcode.cn id=1339 lang=javascript
 *
 * [1339] 分裂二叉树的最大乘积
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
var maxProduct = function(root) {

    const MOD = 1000000007n;

    let total = 0n;
    let max = 0n;

    // 求总和
    function getSum(node) {

        if (!node) {
            return 0n;
        }

        return BigInt(node.val)
            + getSum(node.left)
            + getSum(node.right);
    }

    total = getSum(root);

    // 后序遍历
    function dfs(node) {

        if (!node) {
            return 0n;
        }

        let left = dfs(node.left);
        let right = dfs(node.right);

        let sum = BigInt(node.val) + left + right;

        // 乘积
        let product = sum * (total - sum);

        // 更新最大值
        if (product > max) {
            max = product;
        }

        return sum;
    }

    dfs(root);

    return Number(max % MOD);
};
// @lc code=end

