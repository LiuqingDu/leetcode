/*
 * @lc app=leetcode.cn id=1491 lang=javascript
 *
 * [1491] 去掉最低工资和最高工资后的工资平均值
 */

// @lc code=start
/**
 * @param {number[]} salary
 * @return {number}
 */
var average = function(salary) {
    let maxValue = Math.max(...salary);
    let minValue = Math.min(...salary);
    let sum = salary.reduce((acc, cur) => acc + cur, 0);
    sum -= maxValue + minValue;
    return sum / (salary.length - 2);
};
// @lc code=end

