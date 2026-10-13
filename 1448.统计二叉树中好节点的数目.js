/*
 * @lc app=leetcode.cn id=1448 lang=javascript
 *
 * [1448] 统计二叉树中好节点的数目
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
var goodNodes = function(root) {
    
    const dfs = (root, path_max) => {
        if (root == null) {
            return 0;
        }
        let res = 0;
        if (root.val >= path_max) {
            res++;
            path_max = root.val;
        }
        res += dfs(root.left, path_max) + dfs(root.right, path_max);
        return res;
    }
    return dfs(root, -Infinity);

};
// @lc code=end

