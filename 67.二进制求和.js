/*
 * @lc app=leetcode.cn id=67 lang=javascript
 *
 * [67] 二进制求和
 */

// @lc code=start
/**
 * @param {string} a
 * @param {string} b
 * @return {string}
 */
var addBinary = function(a, b) {

    let res = "";
    let c = 0;

    for (let i = a.length - 1, j = b.length - 1; i >= 0 || j >= 0; i--, j--) {
        let s = c;
        s += i >= 0 ? parseInt(a[i]) : 0;
        s += j >= 0 ? parseInt(b[j]) : 0;
        res += s % 2;
        c = Math.floor(s / 2);
    }

    res += c === 1 ? 1 : "";
    return res.split("").reverse().join("");

};
// @lc code=end

