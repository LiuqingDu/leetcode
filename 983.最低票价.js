/*
 * @lc app=leetcode.cn id=983 lang=javascript
 *
 * [983] 最低票价
 */

// @lc code=start
/**
 * @param {number[]} days
 * @param {number[]} costs
 * @return {number}
 */
var mincostTickets = function(days, costs) {
    const travelDays = new Set(days);
    const lastDay = days[days.length - 1];
    
    const dp = new Array(lastDay + 31).fill(0);

    for (let i = lastDay; i >= 1; i--) {
        if (!travelDays.has(i)) {
            dp[i] = dp[i + 1];
        } else {
            dp[i] = Math.min(
                costs[0] + dp[i + 1],
                costs[1] + dp[i + 7], 
                costs[2] + dp[i + 30]
            );
        }
    }

    return dp[1];
};
// @lc code=end

