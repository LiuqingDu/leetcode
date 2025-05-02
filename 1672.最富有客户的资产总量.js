/*
 * @lc app=leetcode.cn id=1672 lang=javascript
 *
 * [1672] 最富有客户的资产总量
 */

// @lc code=start
/**
 * @param {number[][]} accounts
 * @return {number}
 */
var maximumWealth = function(accounts) {
    let maxWealth = -Number.MAX_VALUE;
    for (const account of accounts) {
        maxWealth = Math.max(maxWealth, account.reduce((a, b) => a + b));
    }
    return maxWealth;
};
// @lc code=end

