/*
 * @lc app=leetcode.cn id=1281 lang=javascript
 *
 * [1281] 整数的各位积和之差
 */

// @lc code=start
/**
 * @param {number} n
 * @return {number}
 */
var subtractProductAndSum = function(n) {
    let m = 1, s = 0;
    while (n > 0) {
        let x = n % 10;
        n = Math.floor(n / 10);
        m *= x;
        s += x;
    }
    return m - s;
};
// @lc code=end

