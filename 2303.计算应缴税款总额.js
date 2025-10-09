/*
 * @lc app=leetcode.cn id=2303 lang=javascript
 *
 * [2303] 计算应缴税款总额
 */

// @lc code=start
/**
 * @param {number[][]} brackets
 * @param {number} income
 * @return {number}
 */
var calculateTax = function(brackets, income) {
    let totalTax = 0;
    let lower = 0;
    for (const bracket of brackets) {
        const upper = bracket[0], percent = bracket[1];
        const tax = (Math.min(income, upper) - lower) * percent;
        totalTax += tax;
        if (income <= upper) {
            break;
        }
        lower = upper;
    }
    return totalTax / 100.0;
};
// @lc code=end

