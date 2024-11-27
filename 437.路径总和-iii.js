/*
 * @lc app=leetcode.cn id=437 lang=javascript
 *
 * [437] 路径总和 III
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
 * @return {number}
 */
var pathSum = function(root, targetSum) {
    const prefixSumMap = new Map();
    prefixSumMap.set(0, 1);

    const dfs = (node, currentSum) => {
        if (node === null) return 0;

        currentSum += node.val;

        let pathCount = prefixSumMap.get(currentSum - targetSum) || 0;

        prefixSumMap.set(currentSum, (prefixSumMap.get(currentSum) || 0) + 1);

        pathCount += dfs(node.left, currentSum);
        pathCount += dfs(node.right, currentSum);

        prefixSumMap.set(currentSum, prefixSumMap.get(currentSum) - 1);

        return pathCount;
    };

    return dfs(root, 0);
};
// @lc code=end

