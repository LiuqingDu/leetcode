/*
 * @lc app=leetcode.cn id=1544 lang=javascript
 *
 * [1544] 整理字符串
 */

// @lc code=start
/**
 * @param {string} s
 * @return {string}
 */
var makeGood = function(s) {
    let stack = [];
    let n = s.length;
    for (let i = 0; i < n; i++) {
        if (stack.length === 0) {
            stack.push(s[i]);
        } else {
            let a = stack[stack.length-1].charCodeAt(0);
            let b = s[i].charCodeAt(0);
            if (a - b === 32 || b - a === 32) {
                stack.pop();
            } else {
                stack.push(s[i]);
            }
        }
    }
    return stack.join("");
};
// @lc code=end

