/*
 * @lc app=leetcode.cn id=1572 lang=javascript
 *
 * [1572] 矩阵对角线元素的和
 */

// @lc code=start
/**
 * @param {number[][]} mat
 * @return {number}
 */
var diagonalSum = function(mat) {
    let n = mat.length;
    let res = 0;
    for (let i = 0; i < n; i++) {
        res += mat[i][i];
        res += mat[n - 1 - i][i];
    }
    if (n % 2 === 1) {
        let x = Math.floor(n / 2);
        res -= mat[x][x];
    }
    return res;
};
// @lc code=end

