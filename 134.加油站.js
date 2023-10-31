/*
 * @lc app=leetcode.cn id=134 lang=javascript
 *
 * [134] 加油站
 */

// @lc code=start
/**
 * @param {number[]} gas
 * @param {number[]} cost
 * @return {number}
 */
var canCompleteCircuit = function(gas, cost) {

    let total = 0;
    let min = 0;
    let res = -1;
    let n = gas.length;

    for (let i = 0; i < n; i++) {
        total += gas[i] - cost[i];
        if (total < min) {
            res = i;
            min = total;
        }
    }

    if (total < 0) {
        return -1;
    } else {
        return (res + 1) % n;
    }

};
// @lc code=end

