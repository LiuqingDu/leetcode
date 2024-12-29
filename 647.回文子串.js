/*
 * @lc app=leetcode.cn id=647 lang=javascript
 *
 * [647] 回文子串
 */

// @lc code=start
/**
 * @param {string} s
 * @return {number}
 */
var countSubstrings = function(s) {
    let centerSpread = function(cs, l, r) {
        while (0 <= l && r < cs.length && cs[l] == cs[r]) {
            l--;
            r++;
        }
        return Math.floor((r - l) / 2);
    }

    let n = s.length;
    let res = 1;

    for (let i = 0; i < n - 1; i++) {
        res += centerSpread(s, i, i) + centerSpread(s, i, i+1);
    }

    return res;
};
// @lc code=end

