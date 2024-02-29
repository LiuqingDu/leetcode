/*
 * @lc app=leetcode.cn id=103 lang=javascript
 *
 * [103] 二叉树的锯齿形层序遍历
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
 * @return {number[][]}
 */
var zigzagLevelOrder = function(root) {

    if (!root) {
        return [];
    }

    let res = [];
    let queue = [];
    queue.push(root);
    let dir = true;

    while (queue.length) {
        let n = queue.length;
        let line = [];
        for (let i = 0; i < n; i++) {
            let cur = queue.shift();
            line.push(cur.val);
            if (cur.left) {
                queue.push(cur.left);
            }
            if (cur.right) {
                queue.push(cur.right);
            }
        }
        if (!dir) {
            line.reverse();
        }
        res.push(line);
        dir = !dir;
    }

    return res;

};
// @lc code=end

