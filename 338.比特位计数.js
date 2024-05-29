/*
 * @lc app=leetcode.cn id=338 lang=javascript
 *
 * [338] 比特位计数
 */

// @lc code=start
/**
 * @param {number} n
 * @return {number[]}
 */
var countBits = function(n) {

    let res = new Array(n + 1).fill(0);

    for (let i = 1; i <= n; i++) {
        if (i % 2 == 1) {
            res[i] = res[i - 1] + 1;
        } else {
            res[i] = res[i / 2];
        }
    }
    return res;

};
// @lc code=end

