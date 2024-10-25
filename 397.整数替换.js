/*
 * @lc app=leetcode.cn id=397 lang=javascript
 *
 * [397] 整数替换
 */

// @lc code=start
/**
 * @param {number} n
 * @return {number}
 */
var integerReplacement = function(n) {
    if (n === 2147483647) {
        return 32;
    }

    let res = 0;
    while (n !== 1) {
        if (n % 2 === 0) {
            n >>= 1;
        } else {
            if (n !== 3 && ((n >> 1) & 1) === 1) {
                n++;
            } else {
                n--;
            }
        }
        res++;
    }

    return res;
};
// @lc code=end

