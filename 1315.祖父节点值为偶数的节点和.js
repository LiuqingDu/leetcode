/*
 * @lc app=leetcode.cn id=1315 lang=javascript
 *
 * [1315] 祖父节点值为偶数的节点和
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
var sumEvenGrandparent = function(root) {
    let sum = 0;

    function dfs(node, parent, grandParent) {
        if (!node) return;

        // 如果祖父节点存在且为偶数
        if (grandParent && grandParent.val % 2 === 0) {
            sum += node.val;
        }

        // 递归左右子树：更新 parent 和 grandParent
        dfs(node.left, node, parent);
        dfs(node.right, node, parent);
    }

    dfs(root, null, null);
    return sum;
};
// @lc code=end

