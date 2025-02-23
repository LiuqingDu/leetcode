/*
 * @lc app=leetcode.cn id=1221 lang=javascript
 *
 * [1221] 分割平衡字符串
 */

// @lc code=start
/**
 * @param {string} s
 * @return {number}
 */
var balancedStringSplit = function(s) {
    let count = 0;
    let res = 0;
    for (let c of s) {
        count += c === 'R' ? 1 : -1;
        if (count === 0) {
            res += 1;
        }
    }
    return res;
};
// @lc code=end

