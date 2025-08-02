/*
 * @lc app=leetcode.cn id=2073 lang=javascript
 *
 * [2073] 买票需要的时间
 */

// @lc code=start
/**
 * @param {number[]} tickets
 * @param {number} k
 * @return {number}
 */
var timeRequiredToBuy = function(tickets, k) {
    let sum = 0;
    let n = tickets.length;
    let m = tickets[k];
    for (let i = 0; i < n; i++) {
        if (i <= k) {
            sum += Math.min(tickets[i], m);
        } else {
            sum += Math.min(tickets[i], m - 1);
        }
    }
    return sum;
};
// @lc code=end

