/*
 * @lc app=leetcode.cn id=1528 lang=javascript
 *
 * [1528] 重新排列字符串
 */

// @lc code=start
/**
 * @param {string} s
 * @param {number[]} indices
 * @return {string}
 */
var restoreString = function(s, indices) {
    let n = indices.length;
    let res = new Array(n);
    for (let i = 0; i < n; i++) {
        res[indices[i]] = s.charAt(i);
    }
    return res.join("");
};
// @lc code=end

