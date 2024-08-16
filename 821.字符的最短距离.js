/*
 * @lc app=leetcode.cn id=821 lang=javascript
 *
 * [821] 字符的最短距离
 */

// @lc code=start
/**
 * @param {string} s
 * @param {character} c
 * @return {number[]}
 */
var shortestToChar = function(s, c) {
    let n = s.length;
    let res = new Array(n).fill(n + 1);

    for (let i = 0, j = -1; i < n; i++) {
        if (s.charAt(i) === c) {
            j = i;
        }

        if (j !== -1) {
            res[i] = i - j;
        }
    }

    for (let i = n - 1, j = -1; i >= 0; i--) {
        if (s.charAt(i) === c) {
            j = i;
        }

        if (j !== -1) {
            res[i] = Math.min(res[i], j - i);
        }
    }

    return res;
};
// @lc code=end

