/*
 * @lc app=leetcode.cn id=1018 lang=javascript
 *
 * [1018] 可被 5 整除的二进制前缀
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {boolean[]}
 */
var prefixesDivBy5 = function(nums) {
    let result = [];
    let num = 0;

    for (let bit of nums) {
        num = (num * 2 + bit) % 5;
        result.push(num === 0);
    }

    return result;
};
// @lc code=end

