/*
 * @lc app=leetcode.cn id=2553 lang=javascript
 *
 * [2553] 分割数组中数字的数位
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number[]}
 */
var separateDigits = function(nums) {
    let result = [];
    for (let num of nums) {
        let strNum = num.toString();
        for (let char of strNum) {
            result.push(parseInt(char));
        }
    }
    return result;
};
// @lc code=end

