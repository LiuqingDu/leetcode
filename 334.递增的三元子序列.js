/*
 * @lc app=leetcode.cn id=334 lang=javascript
 *
 * [334] 递增的三元子序列
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {boolean}
 */
var increasingTriplet = function(nums) {
    
    let a = Number.MAX_VALUE, b = Number.MAX_VALUE;

    for (let num of nums) {
        if (num > b) {
            return true;
        } else if (num > a && num < b) {
            b = num;
        } else if (num < a) {
            a = num;
        }
    }

    return false;

};
// @lc code=end

