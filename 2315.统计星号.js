/*
 * @lc app=leetcode.cn id=2315 lang=javascript
 *
 * [2315] 统计星号
 */

// @lc code=start
/**
 * @param {string} s
 * @return {number}
 */
var countAsterisks = function (s) {
    let count = 0, inside = false;
    for (let c of s) {
        if (c === '|') inside = !inside;
        else if (c === '*' && !inside) count++;
    }
    return count;
};
// @lc code=end

