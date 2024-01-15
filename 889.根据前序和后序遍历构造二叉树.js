/*
 * @lc app=leetcode.cn id=889 lang=javascript
 *
 * [889] 根据前序和后序遍历构造二叉树
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
 * @param {number[]} preorder
 * @param {number[]} postorder
 * @return {TreeNode}
 */
var constructFromPrePost = function(preorder, postorder) {

    let valToIndex = new Map();
    for (let i = 0; i < postorder.length; i++) {
        valToIndex.set(postorder[i], i);
    }

    let build = function(preorder, prestart, preend, postorder, poststart, postend) {
        if (prestart > preend) {
            return null;
        }

        if (prestart === preend) {
            return new TreeNode(preorder[prestart]);
        }

        let rootVal = preorder[prestart];
        let root = new TreeNode(rootVal);

        let leftVal = preorder[prestart + 1];
        let index = valToIndex.get(leftVal);
        let leftSize = index - poststart + 1;

        root.left = build(preorder, prestart + 1, prestart + leftSize, postorder, poststart, index);
        root.right = build(preorder, prestart + leftSize + 1, preend, postorder, index + 1, postend - 1);

        return root;
    }

    return build(preorder, 0, preorder.length - 1, postorder, 0, postorder.length - 1);

};
// @lc code=end

