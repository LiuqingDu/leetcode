/*
 * @lc app=leetcode.cn id=1457 lang=javascript
 *
 * [1457] 二叉树中的伪回文路径
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
var pseudoPalindromicPaths  = function(root) {
    
    let count = 0;

    // helper 函数进行深度优先搜索 (DFS)
    const dfs = (node, path) => {
        if (!node) return;

        // 1. 用异或运算切换对应数字的“开关”状态
        path ^= (1 << node.val);

        // 2. 到达叶子节点，检查当前路径是否满足伪回文条件
        if (!node.left && !node.right) {
            // path & (path - 1) === 0 说明二进制中最多只有 1 个 1
            if ((path & (path - 1)) === 0) {
                count++;
            }
            return;
        }

        // 3. 递归左右子树
        dfs(node.left, path);
        dfs(node.right, path);
    };

    dfs(root, 0);
    return count;
};
// @lc code=end

