/*
 * @lc app=leetcode.cn id=3330 lang=javascript
 *
 * [3330] 找到初始输入字符串 I
 */

// @lc code=start
/**
 * @param {string} word
 * @return {number}
 */
var possibleStringCount = function(word) {
    let n = word.length, res = 1;

    for (let i = 1; i < n; i++) {
        if (word.charAt(i - 1) === word.charAt(i)) {
            res++;
        }
    }
    return res;
};
// @lc code=end

