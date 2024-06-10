/*
 * @lc app=leetcode.cn id=414 lang=javascript
 *
 * [414] 第三大的数
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var thirdMax = function(nums) {
    let a = b = c = null;
    for (let num of nums) {
        if (a === null || num > a) {
            c = b;
            b = a;
            a = num;
        } else if (num < a && (b === null || num > b)) {
            c = b;
            b = num;
        } else if ((b !== null && num < b) && (c === null || num > c)) {
            c = num;
        }
    }
    return c === null ? a : c;
};
// @lc code=end

