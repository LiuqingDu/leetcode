/*
 * @lc app=leetcode.cn id=1844 lang=javascript
 *
 * [1844] 将所有数字用字符替换
 */

// @lc code=start
/**
 * @param {string} s
 * @return {string}
 */
var replaceDigits = function(s) {
    let n = s.length;
    let result = '';
    for (let i = 0; i < n; i += 2) {
        result += s[i];
        if (i + 1 < n) {
            let digit = parseInt(s[i + 1], 10);
            let newChar = String.fromCharCode(s.charCodeAt(i) + digit);
            result += newChar;
        }
    }
    return result;
};
// @lc code=end

