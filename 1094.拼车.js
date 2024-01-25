/*
 * @lc app=leetcode.cn id=1094 lang=javascript
 *
 * [1094] 拼车
 */

// @lc code=start
/**
 * @param {number[][]} trips
 * @param {number} capacity
 * @return {boolean}
 */
var carPooling = function(trips, capacity) {
    
    let arr = Array(1001).fill(0);
    for (let trip of trips) {
        arr[trip[1]] += trip[0];
        arr[trip[2]] -= trip[0];
    }

    let sum = 0;
    for (let i = 0; i <= 1000; i++) {
        sum += arr[i];
        if (sum > capacity) {
            return false;
        }
    }

    return true;
};
// @lc code=end

