/*
 * @lc app=leetcode.cn id=1380 lang=javascript
 *
 * [1380] 矩阵中的幸运数
 */

// @lc code=start
/**
 * @param {number[][]} matrix
 * @return {number[]}
 */
var luckyNumbers = function(matrix) {
    let m = matrix.length;
    let n = matrix[0].length;

    let rowMax = 0, k = 0;

    for (let i = 0; i < m; i++) {
        let curMin = matrix[i][0];
        let c = 0;
        for (let j = 1; j < n; j++) {
            if (curMin > matrix[i][j]) {
                curMin = matrix[i][j];
                c = j;
            }
        }
        if (rowMax < curMin) {
            rowMax = curMin;
            k = c;
        }
    }

    for (let i = 0; i < m; i++) {
        if (rowMax < matrix[i][k]) {
            return [];
        }
    }

    return [rowMax];
};
// @lc code=end

