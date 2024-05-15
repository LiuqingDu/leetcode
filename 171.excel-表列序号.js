/*
 * @lc app=leetcode.cn id=171 lang=javascript
 *
 * [171] Excel 表列序号
 */

// @lc code=start
/**
 * @param {string} columnTitle
 * @return {number}
 */
var titleToNumber = function(columnTitle) {
    let res =0;
    for (let i = 0; i < columnTitle.length; i++) {
        res = res * 26 + (columnTitle.charCodeAt(i) - 'A'.charCodeAt(0) + 1);
    }
    return res;

};
// @lc code=end

