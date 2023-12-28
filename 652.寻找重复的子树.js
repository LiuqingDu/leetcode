/*
 * @lc app=leetcode.cn id=652 lang=javascript
 *
 * [652] 寻找重复的子树
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
 * @return {TreeNode[]}
 */
var findDuplicateSubtrees = function(root) {

    let res = [];

    let memo = new Map();

    let traversal = function(node) {
        if (!node) {
            return "!";
        }

        let left = traversal(node.left);
        let right = traversal(node.right);

        let str = left + "," + right + "," + node.val;

        if (memo.has(str)) {
            if (memo.get(str) === 1) {
                res.push(node);
            }
            memo.set(str, memo.get(str) + 1);
        } else {
            memo.set(str, 1);
        }

        return str;
    }

    traversal(root);

    return res;

};
// @lc code=end

