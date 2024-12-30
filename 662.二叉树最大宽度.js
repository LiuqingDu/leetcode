/*
 * @lc app=leetcode.cn id=662 lang=javascript
 *
 * [662] 二叉树最大宽度
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
var widthOfBinaryTree = function(root) {
    let map = new Map();
    let res = 0;

    let dfs = function(root, u, depth) {
        if (!root) {
            return;
        }
        if (!map.has(depth)) {
            map.set(depth, u);
        }
        res = Math.max(res, u - map.get(depth) + 1);
        u = u - map.get(depth) + 1;
        dfs(root.left, u * 2, depth + 1);
        dfs(root.right, u * 2 + 1, depth + 1);
    }

    dfs(root, 1, 0);
    return res;
};
// @lc code=end

