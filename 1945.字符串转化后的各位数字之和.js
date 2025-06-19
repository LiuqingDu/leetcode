/*
 * @lc app=leetcode.cn id=1945 lang=javascript
 *
 * [1945] 字符串转化后的各位数字之和
 */

// @lc code=start
/**
 * @param {string} s
 * @param {number} k
 * @return {number}
 */
var getLucky = function(s, k) {
    let numStr = '';
    for (let ch of s) {
        numStr += (ch.charCodeAt(0) - 96).toString(); // 'a'.charCodeAt(0) === 97
    }

    while (k-- > 0) {
        let sum = 0;
        for (let digit of numStr) {
            sum += Number(digit);
        }
        numStr = sum.toString();
    }

    return parseInt(numStr);
};
// @lc code=end

