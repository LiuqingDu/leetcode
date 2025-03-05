/*
 * @lc app=leetcode.cn id=1295 lang=javascript
 *
 * [1295] 统计位数为偶数的数字
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var findNumbers = function(nums) {
    let res = 0;
    for (let num of nums) {
        if (num.toString().length % 2 === 0) {
            res++;
        }
    }
    return res;
};
// @lc code=end

