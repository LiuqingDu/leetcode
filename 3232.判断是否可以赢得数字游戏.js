/*
 * @lc app=leetcode.cn id=3232 lang=javascript
 *
 * [3232] 判断是否可以赢得数字游戏
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {boolean}
 */
var canAliceWin = function(nums) {
    
    let single_digit_sum = 0;
    let double_digit_sum = 0;
    for (const num of nums) {
        if (num < 10) {
            single_digit_sum += num;
        } else {
            double_digit_sum += num;
        }
    }
    return single_digit_sum != double_digit_sum;

};
// @lc code=end

