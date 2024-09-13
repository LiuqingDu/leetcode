/*
 * @lc app=leetcode.cn id=944 lang=javascript
 *
 * [944] 删列造序
 */

// @lc code=start
/**
 * @param {string[]} strs
 * @return {number}
 */
var minDeletionSize = function(strs) {
    let row = strs.length;
    let col = strs[0].length;
    let res = 0;

    for (let j = 0; j < col; j++) {
        for (let i = 1; i < row; i++) {
            if (strs[i - 1][j] > strs[i][j]) {
                res++;
                break;
            }
        }
    }
    return res;
};
// @lc code=end

