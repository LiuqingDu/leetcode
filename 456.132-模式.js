/*
 * @lc app=leetcode.cn id=456 lang=javascript
 *
 * [456] 132 模式
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {boolean}
 */
var find132pattern = function(nums) {
    const n = nums.length;
    const stack = [];
    let k = -Infinity;

    for (let i = n - 1; i >= 0; i--) {
        if (nums[i] < k) return true;

        while (stack.length && stack[stack.length - 1] < nums[i]) {
            k = Math.max(k, stack.pop());
        }

        stack.push(nums[i]);
    }

    return false;
};
// @lc code=end

