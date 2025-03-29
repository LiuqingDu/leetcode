/*
 * @lc app=leetcode.cn id=1417 lang=javascript
 *
 * [1417] 重新格式化字符串
 */

// @lc code=start
/**
 * @param {string} s
 * @return {string}
 */
var reformat = function(s) {
    let num1 = 0, num2 = 0;
    const chars = s.split('');
    for (let c of chars) {
        if (c >= '0' && c <= '9') {
            num1++;
        } else {
            num2++;
        }
    }
    if (Math.abs(num1 - num2) > 1) {
        return '';
    }
    if (num1 > num2) {
        num1 = 0;
        num2 = 1;
    } else {
        num1 = 1;
        num2 = 0;
    }
    for (let c of s) {
        if (c >= '0' && c <= '9') {
            chars[num1] = c;
            num1 += 2;
        } else {
            chars[num2] = c;
            num2 += 2;
        }
    }

    return chars.join('');
};
// @lc code=end

