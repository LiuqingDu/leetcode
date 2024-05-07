/*
 * @lc app=leetcode.cn id=12 lang=javascript
 *
 * [12] 整数转罗马数字
 */

// @lc code=start
/**
 * @param {number} num
 * @return {string}
 */
var intToRoman = function(num) {
    let nums = [1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1];
    let romas = ["M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"];

    let res = "";
    let i = 0;
    
    while (i < 13) {
        while (num >= nums[i]) {
            res += romas[i];
            num -= nums[i];
        }
        i++;
    }

    return res;
};
// @lc code=end

