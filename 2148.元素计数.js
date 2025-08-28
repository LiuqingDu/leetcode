/*
 * @lc app=leetcode.cn id=2148 lang=javascript
 *
 * [2148] 元素计数
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var countElements = function(nums) {
    let max = Number.MIN_SAFE_INTEGER;
    let min = Number.MAX_SAFE_INTEGER;
    for (let nums of nums) {
        if (num > max) {
            max = num;
        }
        if (num < min) {
            min = num;
        }
    }
    let res = 0;
    for (let num of nums) {
        if (num > min && num < max) {
            res++;
        }
    }
    return res;
};
// @lc code=end

