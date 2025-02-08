/*
 * @lc app=leetcode.cn id=1137 lang=javascript
 *
 * [1137] 第 N 个泰波那契数
 */

// @lc code=start
/**
 * @param {number} n
 * @return {number}
 */
var tribonacci = function(n) {
    if (n === 0) {
        return 0;
    }
    if (n < 3) {
        return 1;
    }
    let a = 0, b = 1, c = 1;
    let i = 3;
    while (i <= n) {
        let d = a + b + c;
        a = b;
        b = c;
        c = d;
        i++;
    }
    return c;
};
// @lc code=end

