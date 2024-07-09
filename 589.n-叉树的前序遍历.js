/*
 * @lc app=leetcode.cn id=589 lang=javascript
 *
 * [589] N 叉树的前序遍历
 */

// @lc code=start
/**
 * // Definition for a _Node.
 * function _Node(val, children) {
 *    this.val = val;
 *    this.children = children;
 * };
 */

/**
 * @param {_Node|null} root
 * @return {number[]}
 */
var preorder = function(root) {
    let res = [];
    let pre = function(node) {
        if (!node) {
            return;
        }
        res.push(node.val);
        for (let n of node.children) {
            pre(n);
        }
    }
    pre(root);
    return res;
};
// @lc code=end

