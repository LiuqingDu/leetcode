/*
 * @lc app=leetcode.cn id=678 lang=javascript
 *
 * [678] 有效的括号字符串
 */

// @lc code=start
/**
 * @param {string} s
 * @return {boolean}
 */
var checkValidString = function(s) {
    let n = s.length;
    let balance = 0;

    for (let i = 0; i < n; i++) {
        let ch = s[i];
        if (ch === '(' || ch === '*') {
            balance++;
        } else {
            balance--;
            if (balance < 0) {
                return false;
            }
        }
    }

    balance = 0;

    for (let i = n - 1; i >= 0; i--) {
        let ch = s[i];
        if (ch === ')' || ch === '*') {
            balance++;
        } else {
            balance--;
            if (balance < 0) {
                return false;
            }
        }
    }

    return true;
};
// @lc code=end

