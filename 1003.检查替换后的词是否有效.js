/*
 * @lc app=leetcode.cn id=1003 lang=javascript
 *
 * [1003] 检查替换后的词是否有效
 */

// @lc code=start
/**
 * @param {string} s
 * @return {boolean}
 */
var isValid = function(s) {
    const stk = [];
    for (let i = 0; i < s.length; i++) {
        const c = s[i];
        stk.push(c);
        if (stk.length >= 3 && stk.slice(stk.length - 3).join("") === "abc") {
            stk.splice(stk.length - 3, 3);
        }
    }
    return stk.length === 0;
};
// @lc code=end

