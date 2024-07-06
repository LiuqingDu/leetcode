/*
 * @lc app=leetcode.cn id=566 lang=javascript
 *
 * [566] 重塑矩阵
 */

// @lc code=start
/**
 * @param {number[][]} mat
 * @param {number} r
 * @param {number} c
 * @return {number[][]}
 */
var matrixReshape = function(mat, r, c) {
    let m = mat.length;
    let n = mat[0].length;
    if (m * n !== r * c) {
        return mat;
    }

    let total = m * n;
    let res = Array.from(Array(r), () => Array(c));
    for (let i = 0; i < total; i++) {
        res[Math.floor(i / c)][i % c] = mat[Math.floor(i / n)][i % n];
    }
    return res;
};
// @lc code=end

