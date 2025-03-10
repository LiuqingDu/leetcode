/*
 * @lc app=leetcode.cn id=1309 lang=javascript
 *
 * [1309] 解码字母到整数映射
 */

// @lc code=start
/**
 * @param {string} s
 * @return {string}
 */
var freqAlphabets = function(s) {
    let result = '';
    let i = s.length - 1;

    while (i >= 0) {
        if (i >= 2 && s[i] === '#') {
            let num = parseInt(s.substring(i - 2, i));
            result = String.fromCharCode('a'.charCodeAt(0) + num - 1) + result;
            i -= 3;
        } else {
            let num = s[i] - '0';
            result = String.fromCharCode('a'.charCodeAt(0) + num - 1) + result;
            i--;
        }
    }
    return result;
};
// @lc code=end

