/*
 * @lc app=leetcode.cn id=50 lang=javascript
 *
 * [50] Pow(x, n)
 */

// @lc code=start
/**
 * @param {number} x
 * @param {number} n
 * @return {number}
 */
var myPow = function(x, n) {

    let quickMulti = function(x, N) {
        let res = 1.0;
        let k = x;
        while (N > 0) {
            if (N % 2 === 1) {
                res *= k;
            }
            k *= k;
            N = Math.floor(N / 2);
        }
        return res;
    }

    return n >= 0 ? quickMulti(x, n) : 1 / quickMulti(x, -n);

};
// @lc code=end

