/*
 * @lc app=leetcode.cn id=1957 lang=javascript
 *
 * [1957] 删除字符使字符串变好
 */

// @lc code=start
/**
 * @param {string} s
 * @return {string}
 */
var makeFancyString = function(s) {
    let result = '';
    let count = 1;

    for (let i = 0; i < s.length; i++) {
        if (i > 0 && s[i] === s[i - 1]) {
            count++;
        } else {
            count = 1;
        }

        if (count < 3) {
            result += s[i];
        }
    }

    return result;
};
// @lc code=end

