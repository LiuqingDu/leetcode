/*
 * @lc app=leetcode.cn id=199 lang=javascript
 *
 * [199] 二叉树的右视图
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
var rightSideView = function(root) {

    if (!root) {
        return [];
    }

    let queue = [];
    let res = [];

    queue.push(root);

    while(queue.length) {
        res.push(queue[0].val);
        let n = queue.length;
        for (let i = 0; i < n; i++) {
            let node = queue.shift();
            if (node.right) {
                queue.push(node.right);
            }
            if (node.left) {
                queue.push(node.left);
            }
        }
    }

    return res;

};
// @lc code=end

