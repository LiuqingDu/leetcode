/*
 * @lc app=leetcode.cn id=173 lang=javascript
 *
 * [173] 二叉搜索树迭代器
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
 */
var BSTIterator = function(root) {
    this.stack = [];
    while (root) {
        this.stack.push(root);
        root = root.left;
    }
};

/**
 * @return {number}
 */
BSTIterator.prototype.next = function() {
    let cur = this.stack.pop();
    let res = cur.val;
    let node = cur.right;
    while (node) {
        this.stack.push(node);
        node = node.left;
    }
    return res;
};

/**
 * @return {boolean}
 */
BSTIterator.prototype.hasNext = function() {
    return this.stack.length > 0;
};

/**
 * Your BSTIterator object will be instantiated and called as such:
 * var obj = new BSTIterator(root)
 * var param_1 = obj.next()
 * var param_2 = obj.hasNext()
 */
// @lc code=end

