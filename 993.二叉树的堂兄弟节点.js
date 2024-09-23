/*
 * @lc app=leetcode.cn id=993 lang=javascript
 *
 * [993] 二叉树的堂兄弟节点
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
 * @param {number} x
 * @param {number} y
 * @return {boolean}
 */
var isCousins = function(root, x, y) {
    let depth1 = 0, depth2 = 0;
    let parent1 = null, parent2 = null;

    let dfs = function(node, parent, x, y, depth) {
        if (!node) {
            return;
        }
        if (node.val == x) {
            depth1 = depth;
            parent1 = parent;
        }
        if (node.val == y) {
            depth2 = depth;
            parent2 = parent;
        }

        dfs(node.left, node, x, y, depth + 1);
        dfs(node.right, node, x, y, depth + 1);
    }

    dfs(root, null, x, y, 0);
    return depth1 === depth2 && parent1 !== parent2;
};
// @lc code=end

