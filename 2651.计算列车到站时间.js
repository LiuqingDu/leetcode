/*
 * @lc app=leetcode.cn id=2651 lang=javascript
 *
 * [2651] 计算列车到站时间
 */

// @lc code=start
/**
 * @param {number} arrivalTime
 * @param {number} delayedTime
 * @return {number}
 */
var findDelayedArrivalTime = function(arrivalTime, delayedTime) {
    return (arrivalTime + delayedTime) % 24;
};
// @lc code=end

