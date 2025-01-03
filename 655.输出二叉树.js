/*
 * @lc app=leetcode.cn id=655 lang=javascript
 *
 * [655] 输出二叉树
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
 * @return {string[][]}
 */
var printTree = function(root) {
    
    let calDepth = function (root) {
        if (!root) return 0;
        return 1 + Math.max(calDepth(root.left), calDepth(root.right));
    };

    let dfs = function (res, root, row, col, remainingDepth) {
        if (!root) return;

        res[row][col] = root.val.toString();
        let offset = 1 << (remainingDepth - 1);

        if (root.left !== null) {
            dfs(res, root.left, row + 1, col - offset, remainingDepth - 1);
        }

        if (root.right !== null) {
            dfs(res, root.right, row + 1, col + offset, remainingDepth - 1);
        }
    };

    let height = calDepth(root);
    let m = height;
    let n = (1 << height) - 1;

    let res = Array.from(Array(m), () => Array(n).fill(""));

    dfs(res, root, 0, Math.floor((n - 1) / 2), height - 1);
    return res;
};
// @lc code=end

