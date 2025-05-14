/*
 * @lc app=leetcode.cn id=1732 lang=javascript
 *
 * [1732] 找到最高海拔
 */

// @lc code=start
/**
 * @param {number[]} gain
 * @return {number}
 */
var largestAltitude = function(gain) {
    let ans = 0, sum = 0;
    for (const x of gain) {
        sum += x;
        ans = Math.max(ans, sum);
    }
    return ans;
};
// @lc code=end

