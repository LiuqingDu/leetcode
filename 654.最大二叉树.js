/*
 * @lc app=leetcode.cn id=654 lang=javascript
 *
 * [654] 最大二叉树
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
 * @param {number[]} nums
 * @return {TreeNode}
 */
var constructMaximumBinaryTree = function(nums) {

    let build = function(nums, left, right) {
        if (left > right) {
            return null;
        }

        let max = Number.MIN_VALUE;
        let ind = left;

        for (let i = left; i <= right; i++) {
            if (nums[i] > max) {
                max = nums[i];
                ind = i;
            }
        }

        let node = new TreeNode();
        node.val = max;
        node.left = build(nums, left, ind - 1);
        node.right = build(nums, ind + 1, right);

        return node;
    }

    return build(nums, 0, nums.length - 1);

};
// @lc code=end

