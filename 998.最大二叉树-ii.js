/*
 * @lc app=leetcode.cn id=998 lang=javascript
 *
 * [998] 最大二叉树 II
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
 * @param {number} val
 * @return {TreeNode}
 */
var insertIntoMaxTree = function(root, val) {
    
    let parent = null;
    let cur = root;
    while (cur) {
        if (val > cur.val) {
            if (!parent) {
                return new TreeNode(val, root, null);
            }
            let node = new TreeNode(val, cur, null);
            parent.right = node;
            return root;
        } else {
            parent = cur;
            cur = cur.right;
        }
    }
    parent.right = new TreeNode(val);
    return root;

};
// @lc code=end

