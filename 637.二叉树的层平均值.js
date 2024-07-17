/*
 * @lc app=leetcode.cn id=637 lang=javascript
 *
 * [637] 二叉树的层平均值
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
 * @return {number[]}
 */
var averageOfLevels = function(root) {
    let res = [];
    let queue = [];
    queue.push(root);
    while (queue.length) {
        let sum = 0;
        let size = queue.length;
        for (let i = 0; i < size; i++) {
            let n = queue.shift();
            sum += n.val;
            if (n.left) {
                queue.push(n.left);
            }
            if (n.right) {
                queue.push(n.right);
            }
        }
        res.push(sum / size);
    }
    return res;

};
// @lc code=end

