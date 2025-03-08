/*
 * @lc app=leetcode.cn id=1304 lang=javascript
 *
 * [1304] 和为零的 N 个不同整数
 */

// @lc code=start
/**
 * @param {number} n
 * @return {number[]}
 */
var sumZero = function(n) {
    let res = new Array(n).fill(0);
    let ind = 0;
    for (let i = 1; i <= Math.floor(n/2); i++) {
        res[ind++] = i;
        res[ind++] = -i;
    }
    return res;
};
// @lc code=end

