/*
 * @lc app=leetcode.cn id=806 lang=javascript
 *
 * [806] 写字符串需要的行数
 */

// @lc code=start
/**
 * @param {number[]} widths
 * @param {string} s
 * @return {number[]}
 */
var numberOfLines = function(widths, s) {

    let n = s.length;
    let rows = 1;
    let wid = 0;

    for (let i = 0; i < n; i++) {
        let c = s.charCodeAt(i) - 97;
        let w = widths[c];
        if (wid + w > 100) {
            rows++;
            wid = 0;
        }
        wid += w;
    }

    return [rows, wid];

};
// @lc code=end

