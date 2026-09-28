/*
 * @lc app=leetcode.cn id=1513 lang=javascript
 *
 * [1513] 仅含 1 的子串数
 */

// @lc code=start
/**
 * @param {string} s
 * @return {number}
 */
var numSub = function(s) {
    
    const MODULO = 1000000007;
    let total = 0;
    let consecutive = 0;
    for (const c of s) {
        if (c === '0') {
            total += consecutive * (consecutive + 1) / 2;
            total %= MODULO;
            consecutive = 0;
        } else {
            consecutive++;
        }
    }
    total += consecutive * (consecutive + 1) / 2;
    total %= MODULO;
    return total;

};
// @lc code=end

