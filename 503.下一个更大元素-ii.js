/*
 * @lc app=leetcode.cn id=503 lang=javascript
 *
 * [503] 下一个更大元素 II
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number[]}
 */
var nextGreaterElements = function(nums) {
    let n = nums.length;

    let res = [];

    let stack = [];

    for (let i = 2*n - 1; i >= 0; i--) {
        while(stack.length && stack[stack.length - 1] <= nums[i % n]) {
            stack.pop();
        }

        res[i % n] = stack.length === 0 ? -1 : stack[stack.length - 1];

        stack.push(nums[i % n]);
    }

    return res;

};
// @lc code=end

