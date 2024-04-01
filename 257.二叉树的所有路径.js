/*
 * @lc app=leetcode.cn id=257 lang=javascript
 *
 * [257] 二叉树的所有路径
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
 * @return {string[]}
 */
var binaryTreePaths = function(root) {

    let res = [];

    let dfs = function(node, path,res) {
        if (!node) {
            return;
        }
        path.push(node.val);
        if (!node.left && !node.right) {
            res.push(path.join("->"));
        } else {
            dfs(node.left, path, res);
            dfs(node.right, path, res);
        }
        path.pop();
    }

    dfs(root, [], res);

    return res;

};
// @lc code=end

