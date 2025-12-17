/*
 * @lc app=leetcode.cn id=2643 lang=javascript
 *
 * [2643] 一最多的行
 */

// @lc code=start
/**
 * @param {number[][]} mat
 * @return {number[]}
 */
var rowAndMaximumOnes = function(mat) {
    let res = [0, 0];
    let m = mat.length;
    let n = mat[0].length;

    for (let i = 0; i < m; i++) {
        let c = 0;
        for (let j = 0; j < n; j++) {
            c += mat[i][j];
        }
        if (c > res[1]) {
            res = [i, c];
        }
    }
    return res;
};
// @lc code=end

