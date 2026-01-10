/*
 * @lc app=leetcode.cn id=1123 lang=javascript
 *
 * [1123] 最深叶节点的最近公共祖先
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
var lcaDeepestLeaves = function(root) {
    let f = (node) => {
        // 如果节点为空,则深度为0,公共祖先是自己
        if (!node) {
            return [0, node];
        }

        let [d1, lca1] = f(node.left);
        let [d2, lca2] = f(node.right);

        // 看哪边深度大,就返回这一侧的公共祖先节点,深度+1表示算上自己这一层深度
        if (d1 > d2) {
            return [d1 + 1, lca1];
        }

        if (d1 < d2) {
            return [d2 + 1, lca2];
        }

        // 两边深度一样,那么公共祖先就是自己,因为相当于两边都有最深的叶子节点
        return [d1 + 1, node];
    }

    return f(root)[1];
};
// @lc code=end

