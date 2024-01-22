/*
 * @lc app=leetcode.cn id=455 lang=javascript
 *
 * [455] 分发饼干
 */

// @lc code=start
/**
 * @param {number[]} g
 * @param {number[]} s
 * @return {number}
 */
var findContentChildren = function(g, s) {

    let i = 0, j = 0;
    let m = g.length, n = s.length;

    g.sort((a, b) => a - b);
    s.sort((a, b) => a - b);

    while (i < m && j < n) {
        if (g[i] <= s[j]) {
            i++;
            j++;
        } else {
            j++;
        }
    }

    return i;

};
// @lc code=end

