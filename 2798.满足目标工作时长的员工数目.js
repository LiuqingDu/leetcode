/*
 * @lc app=leetcode.cn id=2798 lang=javascript
 *
 * [2798] 满足目标工作时长的员工数目
 */

// @lc code=start
/**
 * @param {number[]} hours
 * @param {number} target
 * @return {number}
 */
var numberOfEmployeesWhoMetTarget = function(hours, target) {
    return hours.reduce((pre, cur) => pre += cur >= target ? 1 : 0, 0);
};
// @lc code=end

