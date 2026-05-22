/*
 * @lc app=leetcode.cn id=1372 lang=javascript
 *
 * [1372] 二叉树中的最长交错路径
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
var longestZigZag = function(root) {
    // 最终答案
    let ans = 0;

    /**
     * @param {TreeNode} node 当前节点
     * @param {number} len 当前交错长度
     * @param {boolean} isLeft 上一步是否往左走
     */
    function dfs(node, len, isLeft) {

        // 空节点直接返回
        if (!node) return;

        // 更新最大值
        ans = Math.max(ans, len);

        // 如果上一步往左
        if (isLeft) {

            // 下一步往右 -> 交错成功
            dfs(node.right, len + 1, false);

            // 下一步继续往左 -> 重新开始
            dfs(node.left, 1, true);

        } else {

            // 上一步往右

            // 下一步往左 -> 交错成功
            dfs(node.left, len + 1, true);

            // 下一步继续往右 -> 重新开始
            dfs(node.right, 1, false);
        }
    }

    // 从 root 开始尝试

    // 第一条边走左
    dfs(root.left, 1, true);

    // 第一条边走右
    dfs(root.right, 1, false);

    return ans;
};
// @lc code=end

