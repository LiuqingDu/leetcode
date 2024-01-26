/*
 * @lc app=leetcode.cn id=1109 lang=javascript
 *
 * [1109] 航班预订统计
 */

// @lc code=start
/**
 * @param {number[][]} bookings
 * @param {number} n
 * @return {number[]}
 */
var corpFlightBookings = function(bookings, n) {

    let arr = Array(n + 2).fill(0);

    for (b of bookings) {
        arr[b[0]] += b[2];
        arr[b[1] + 1] -= b[2];
    }

    let res = Array(n).fill(0);
    let sum = 0;

    for (let i = 1; i <= n; i++) {
        sum += arr[i];
        res[i - 1] = sum;
    }

    return res;

};
// @lc code=end

