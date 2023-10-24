/*
 * @lc app=leetcode.cn id=95 lang=javascript
 *
 * [95] 不同的二叉搜索树 II
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
var generateTrees = function(n) {

    let traversal = function(min, max) {
        let res = [];

        if (min > max) {
            res.push(null);
            return res;
        }

        for (let i = min; i <= max; i++) {
            let left = traversal(min, i - 1);
            let right = traversal(i + 1, max);
            for (let leftNode of left) {
                for (let rightNode of right) {
                    let node = new TreeNode(i);
                    node.left = leftNode;
                    node.right = rightNode;
                    res.push(node);
                }
            }
        }

        return res;

    }

    return traversal(1, n);

};
// @lc code=end

