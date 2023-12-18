/*
 * @lc app=leetcode.cn id=509 lang=javascript
 *
 * [509] 斐波那契数
 */

// @lc code=start
/**
 * @param {number} n
 * @return {number}
 */
var fib = function(n) {

    if (n < 2) {
        return n;
    }

    let n1 = 0, n2 = 1;
    let res = 0;
    for (let i = 2; i <= n; i++) {
        res = n1 + n2;
        n1 = n2;
        n2 = res;
    }

    return res;
};
// @lc code=end

