/*
 * @lc app=leetcode.cn id=856 lang=javascript
 *
 * [856] 括号的分数
 */

// @lc code=start
/**
 * @param {string} s
 * @return {number}
 */
var scoreOfParentheses = function(s) {
    let d = 0, n = s.length, ans = 0;
    for (let i = 0; i < n; i++) {
        if (s[i] === '(') {
            d++;
        } else {
            d--;
            if (s[i - 1] === '(') {
                ans += 1 << d; // 2^d
            }
        }
    }
    return ans;
};
// @lc code=end

