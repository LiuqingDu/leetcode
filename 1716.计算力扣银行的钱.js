/*
 * @lc app=leetcode.cn id=1716 lang=javascript
 *
 * [1716] 计算力扣银行的钱
 */

// @lc code=start
/**
 * @param {number} n
 * @return {number}
 */
var totalMoney = function(n) {
    let week = 1, day = 1;
    let res = 0;
    for (let i = 0; i < n; ++i) {
        res += week + day - 1;
        ++day;
        if (day === 8) {
            day = 1;
            ++week;
        }
    }
    return res;
};
// @lc code=end

