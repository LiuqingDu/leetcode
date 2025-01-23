/*
 * @lc app=leetcode.cn id=1021 lang=javascript
 *
 * [1021] 删除最外层的括号
 */

// @lc code=start
/**
 * @param {string} s
 * @return {string}
 */
var removeOuterParentheses = function(s) {
    let n = s.length;
    let res = "";
    let count = 0;
    for (let i = 0; i < n; i++) {
        if (s[i] === "(") {
            count++;
            if (count !== 1) {
                res += s[i];
            }
        } else {
            count--;
            if (count !== 0) {
                res += s[i];
            }
        }
    }
    return res;
};
// @lc code=end

