/*
 * @lc app=leetcode.cn id=2778 lang=javascript
 *
 * [2778] 特殊元素平方和
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var sumOfSquares = function(nums) {
    let res = 0;
    let n = nums.length;
    for (let i = 1; i <= n; i++) {
        if (n % i === 0) {
            res += nums[i - 1] * nums[i - 1];
        }
    }
    return res;
};
// @lc code=end

