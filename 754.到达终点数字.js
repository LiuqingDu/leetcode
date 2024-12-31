/*
 * @lc app=leetcode.cn id=754 lang=javascript
 *
 * [754] 到达终点数字
 */

// @lc code=start
/**
 * @param {number} target
 * @return {number}
 */
var reachNumber = function(target) {
    target = Math.abs(target);
    let sum = 0;
    let n = 0;
    while (sum < target || (sum - target) % 2 === 1) {
        n++;
        sum += n;
    }
    return n;
};
// @lc code=end

