/*
 * @lc app=leetcode.cn id=897 lang=javascript
 *
 * [897] 递增顺序搜索树
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
 * @return {TreeNode}
 */
var increasingBST = function(root) {
    let res = new TreeNode();
    let pre = res;

    let traversal = function(node) {
        if (!node) {
            return;
        }

        traversal(node.left);

        node.left = null
        pre.right = node;
        pre = pre.right;
        
        traversal(node.right);
    }

    traversal(root);

    return res.right;
};
// @lc code=end

