/*
 * @lc app=leetcode.cn id=2042 lang=javascript
 *
 * [2042] 检查句子中的数字是否递增
 */

// @lc code=start
/**
 * @param {string} s
 * @return {boolean}
 */
var areNumbersAscending = function(s) {
    const isDigit = (ch) => {
        return parseFloat(ch).toString() === "NaN" ? false : true;
    }

    let pre = 0, pos = 0;
    while (pos < s.length) {
        if (isDigit(s[pos])) {
            let cur = 0;
            while (pos < s.length && isDigit(s[pos])) {
                cur = cur * 10 + s[pos].charCodeAt() - '0'.charCodeAt();
                pos++;
            }
            if (cur <= pre) {
                return false;
            }
            pre = cur;
        } else {
            pos++;
        }
    }
    return true;
};
// @lc code=end

