/*
 * @lc app=leetcode.cn id=2529 lang=javascript
 *
 * [2529] 正整数和负整数的最大计数
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var maximumCount = function(nums) {
    let pos = 0, neg = 0;
    for (const num of nums) {
        if (num > 0) {
            pos++;
        } else if (num < 0) {
            neg++;
        }
    }
    return Math.max(pos, neg);
};
// @lc code=end

