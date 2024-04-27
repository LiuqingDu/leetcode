/*
 * @lc app=leetcode.cn id=337 lang=javascript
 *
 * [337] 打家劫舍 III
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
 * @return {number}
 */
var rob = function(root) {

    let robNode = function(node) {
        if (!node) {
            return [0, 0];
        }

        let res = [0, 0];

        let left = robNode(node.left);
        let right = robNode(node.right);

        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        res[1] = left[0] + right[0] + node.val;
        
        return res;
    }

    let res = robNode(root);
    return Math.max(res[0], res[1]);

};
// @lc code=end

