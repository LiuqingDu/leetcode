/*
 * @lc app=leetcode.cn id=1464 lang=javascript
 *
 * [1464] 数组中两元素的最大乘积
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var maxProduct = function(nums) {
    let a = 0, b = 0;
    for (let num of nums) {
        if (num > a) {
            b = a;
            a = num;
        } else if (num > b) {
            b = num;
        }
    }
    return (a - 1) * (b - 1);
};
// @lc code=end

