/*
 * @lc app=leetcode.cn id=606 lang=javascript
 *
 * [606] 根据二叉树创建字符串
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
 * @return {string}
 */
var tree2str = function(root) {
    
    if (root === null) {
        return "";
    }

    let result = root.val.toString();

    if (root.left) {
        result += `(${tree2str(root.left)})`;
    } else if (root.right) {
        result += `()`;
    }

    if (root.right) {
        result += `(${tree2str(root.right)})`;
    }

    return result;
};
// @lc code=end

