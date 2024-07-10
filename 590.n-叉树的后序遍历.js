/*
 * @lc app=leetcode.cn id=590 lang=javascript
 *
 * [590] N 叉树的后序遍历
 */

// @lc code=start
/**
 * // Definition for a _Node.
 * function _Node(val,children) {
 *    this.val = val;
 *    this.children = children;
 * };
 */

/**
 * @param {_Node|null} root
 * @return {number[]}
 */
var postorder = function(root) {
    let res = [];
    let post = function(node) {
        if (!node) {
            return;
        }
        for (let n of node.children) {
            post(n);
        }

        res.push(node.val);
    }

    post(root);
    return res;
};
// @lc code=end

