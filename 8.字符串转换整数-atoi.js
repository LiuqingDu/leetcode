/*
 * @lc app=leetcode.cn id=8 lang=javascript
 *
 * [8] 字符串转换整数 (atoi)
 */

// @lc code=start
/**
 * @param {string} s
 * @return {number}
 */
var myAtoi = function(s) {

    let index = 0;
    while (index < s.length && s[index] === ' ') {
        index++;
    }

    let sign = 1;
    if (s[index] === '+' || s[index] === '-') {
        sign = s[index] === '+' ? 1 : -1;
        index++;
    }

    let result = 0;
    const maxInt = 2**31 - 1, minInt = -(2**31);
    while (index < s.length && s[index] >= '0' && s[index] <= '9') {
        let digit = s[index] - '0';
        if (result > Math.floor(maxInt / 10) || (result === Math.floor(maxInt / 10) && digit > maxInt % 10)) {
            return sign === 1 ? maxInt : minInt;
        }
        result = result * 10 + digit;
        index++;
    }

    return result * sign;
};
// @lc code=end

