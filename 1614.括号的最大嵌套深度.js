/*
 * @lc app=leetcode.cn id=1614 lang=javascript
 *
 * [1614] 括号的最大嵌套深度
 */

// @lc code=start
/**
 * @param {string} s
 * @return {number}
 */
var maxDepth = function(s) {
    let res = 0;
    let count = 0;
    for (let c of s) {
        if (c === '(') {
            count++;
            res = Math.max(res, count);
        } else if (c === ')') {
            count--;
        }
    }
    return res;
};
// @lc code=end

