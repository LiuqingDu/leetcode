/*
 * @lc app=leetcode.cn id=894 lang=javascript
 *
 * [894] 所有可能的真二叉树
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
 * @param {number} n
 * @return {TreeNode[]}
 */
var allPossibleFBT = function(n) {
    // 偶数不可能是真二叉树
    if (n % 2 === 0) return [];

    const memo = new Map();

    function dfs(n) {
        if (memo.has(n)) {
            return memo.get(n);
        }

        const res = [];

        // 只有一个节点
        if (n === 1) {
            res.push(new TreeNode(0));
            memo.set(n, res);
            return res;
        }

        // 枚举左子树节点数（只可能是奇数）
        for (let left = 1; left < n; left += 2) {
            const right = n - 1 - left;

            const leftTrees = dfs(left);
            const rightTrees = dfs(right);

            // 左右子树做笛卡尔积
            for (const l of leftTrees) {
                for (const r of rightTrees) {
                    const root = new TreeNode(0);
                    root.left = l;
                    root.right = r;
                    res.push(root);
                }
            }
        }

        memo.set(n, res);
        return res;
    }

    return dfs(n);
};
// @lc code=end

