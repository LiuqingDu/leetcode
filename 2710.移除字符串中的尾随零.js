/*
 * @lc app=leetcode.cn id=2710 lang=javascript
 *
 * [2710] 移除字符串中的尾随零
 */

// @lc code=start
/**
 * @param {string} num
 * @return {string}
 */
var removeTrailingZeros = function(num) {
    let len = num.length;
    while (len > 0 && num.charAt(len - 1) === '0') {
        len--;
    }
    return num.substring(0, len);
};
// @lc code=end

