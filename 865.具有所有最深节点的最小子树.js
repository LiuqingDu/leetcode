/*
 * @lc app=leetcode.cn id=865 lang=javascript
 *
 * [865] 具有所有最深节点的最小子树
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
 * @return {TreeNode}
 */
var subtreeWithAllDeepest = function(root) {
    const f = (root) => {
        if (!root) {
        return [0, root];
        }

        let [d1, lca1] = f(root.left);
        let [d2, lca2] = f(root.right);

        if (d1 > d2) {
        return [d1 + 1, lca1];
        }
        if (d1 < d2) {
        return [d2 + 1, lca2];
        }
        return [d1 + 1, root];
    }

    return f(root)[1];
};
// @lc code=end

