/*
 * @lc app=leetcode.cn id=1518 lang=javascript
 *
 * [1518] 换水问题
 */

// @lc code=start
/**
 * @param {number} numBottles
 * @param {number} numExchange
 * @return {number}
 */
var numWaterBottles = function(numBottles, numExchange) {
    let res = numBottles;
    while (numBottles >= numExchange) {
        let exc = Math.floor(numBottles / numExchange);
        res += exc;
        let left = numBottles % numExchange;
        numBottles = exc + left;
    }
    return res;
};
// @lc code=end

