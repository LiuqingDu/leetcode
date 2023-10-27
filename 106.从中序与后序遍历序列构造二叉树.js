/*
 * @lc app=leetcode.cn id=106 lang=javascript
 *
 * [106] 从中序与后序遍历序列构造二叉树
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
 * @param {number[]} inorder
 * @param {number[]} postorder
 * @return {TreeNode}
 */
var buildTree = function(inorder, postorder) {

    let build = function(inorder, postorder) {

        if (!postorder.length) {
            return null;
        }

        let node = new TreeNode();

        node.val = postorder.pop();
        let mid = inorder.indexOf(node.val);

        let left = build(inorder.slice(0, mid), postorder.slice(0, mid));
        let right = build(inorder.slice(mid + 1), postorder.slice(mid));

        node.left = left;
        node.right = right;

        return node;
    }

    return build(inorder, postorder);

};
// @lc code=end

