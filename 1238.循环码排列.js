/*
 * @lc app=leetcode.cn id=1238 lang=javascript
 *
 * [1238] 循环码排列
 */

// @lc code=start
/**
 * @param {number} n
 * @param {number} start
 * @return {number[]}
 */
var circularPermutation = function(n, start) {
    
    const ret = [start];
    for (let i = 1; i <= n; i++) {
        const m = ret.length;
        for (let j = m - 1; j >= 0; j--) {
            ret.push(((ret[j] ^ start) | (1 << (i - 1))) ^ start);
        }
    }
    return ret;

};
// @lc code=end

