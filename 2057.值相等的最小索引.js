/*
 * @lc app=leetcode.cn id=2057 lang=javascript
 *
 * [2057] 值相等的最小索引
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var smallestEqual = function(nums) {
    for (let i = 0; i < nums.length; i++) {
        if (i % 10 === nums[i]) {
            return i;
        }
    }
    return -1;
};
// @lc code=end

