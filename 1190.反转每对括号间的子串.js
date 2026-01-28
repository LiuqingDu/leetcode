/*
 * @lc app=leetcode.cn id=1190 lang=javascript
 *
 * [1190] 反转每对括号间的子串
 */

// @lc code=start
/**
 * @param {string} s
 * @return {string}
 */
var reverseParentheses = function(s) {
    let stack = [];
    let sb = "";

    for (let i = 0; i < s.length; i++) {
        let ch = s[i];
        if (ch === "(") {
            stack.push(sb);
            sb = "";
        } else if (ch === ")") {
            sb = sb.split("").reverse().join("");
            sb = stack.pop() + sb;
        } else {
            sb = sb + ch;
        }
    }

    return sb;
};
// @lc code=end

