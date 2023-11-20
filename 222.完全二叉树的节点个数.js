/*
 * @lc app=leetcode.cn id=222 lang=javascript
 *
 * [222] 完全二叉树的节点个数
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
var countNodes = function(root) {

    if (!root) {
        return 0;
    }

    let hL = 0, hR = 0;
    pL = root.left, pR = root.right;

    while(pL) {
        hL++;
        pL = pL.left;
    }
    while(pR) {
        hR++;
        pR = pR.left;
    }

    if (hL === hR) {
        return (Math.pow(2, hL) - 1) + countNodes(root.right) + 1;
    } else {
        return countNodes(root.left) + (Math.pow(2, hR) - 1) + 1;
    }

};
// @lc code=end

