/*
 * @lc app=leetcode.cn id=2335 lang=javascript
 *
 * [2335] 装满杯子需要的最短总时长
 */

// @lc code=start
/**
 * @param {number[]} amount
 * @return {number}
 */
var fillCups = function(amount) {
    amount.sort((a, b) => a - b);
    if (amount[2] > amount[1] + amount[0]) {
        return amount[2];
    }
    return Math.floor((amount[0] + amount[1] + amount[2] + 1) / 2);
};
// @lc code=end

