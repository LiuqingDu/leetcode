/*
 * @lc app=leetcode.cn id=508 lang=javascript
 *
 * [508] 出现次数最多的子树元素和
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
 * @return {number[]}
 */
var findFrequentTreeSum = function(root) {
    const sumCount = new Map();
    let maxFreq = 0;

    const dfs = (node) => {
        if (!node) return 0;
        const leftSum = dfs(node.left);
        const rightSum = dfs(node.right);
        const currentSum = node.val + leftSum + rightSum;
        sumCount.set(currentSum, (sumCount.get(currentSum) || 0) + 1);
        maxFreq = Math.max(maxFreq, sumCount.get(currentSum));
        return currentSum;
    };

    dfs(root);

    const result = [];
    for (const [sum, freq] of sumCount) {
        if (freq === maxFreq) {
            result.push(sum);
        }
    }

    return result;
};
// @lc code=end

