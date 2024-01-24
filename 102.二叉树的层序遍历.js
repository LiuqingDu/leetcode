/*
 * @lc app=leetcode.cn id=102 lang=javascript
 *
 * [102] 二叉树的层序遍历
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
var levelOrder = function(root) {

    if (!root) {
        return [];
    }

    let queue = [];
    let res = [];
    queue.push(root);

    while (queue.length) {
        let n = queue.length;
        let arr = [];
        for (let i = 0; i < n; i++) {
            let e = queue.shift();
            arr.push(e.val);
            if (e.left) {
                queue.push(e.left);
            }
            if (e.right) {
                queue.push(e.right);
            }
        }
        res.push(arr);
    }

    return res;
};
// @lc code=end

