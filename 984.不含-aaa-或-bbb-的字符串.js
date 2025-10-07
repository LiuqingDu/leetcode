/*
 * @lc app=leetcode.cn id=984 lang=javascript
 *
 * [984] 不含 AAA 或 BBB 的字符串
 */

// @lc code=start
/**
 * @param {number} a
 * @param {number} b
 * @return {string}
 */
var strWithout3a3b = function(a, b) {
    let res = '';
    while (a > b && b > 0) {
        res += 'aab';
        a -= 2;
        b -= 1;
    }
    while (b > a && a > 0) {
        res += 'bba';
        b -= 2;
        a -= 1;
    }
    while (a > 0 && b > 0) {
        res += 'ab';
        a -= 1;
        b -= 1;
    }
    while (a > 0) {
        res += 'a';
        a -= 1;
    }
    while (b > 0) {
        res += 'b';
        b -= 1;
    }
    return res;
};
// @lc code=end

