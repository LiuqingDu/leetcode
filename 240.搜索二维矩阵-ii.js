/*
 * @lc app=leetcode.cn id=240 lang=javascript
 *
 * [240] 搜索二维矩阵 II
 */

// @lc code=start
/**
 * @param {number[][]} matrix
 * @param {number} target
 * @return {boolean}
 */
var searchMatrix = function(matrix, target) {
    let i = 0;
    let j = matrix[0].length - 1;

    while (i < matrix.length && j >= 0) {
        if (matrix[i][j] === target) {
            return true;
        }

        if (matrix[i][j] < target) {
            i++;
        } else {
            j--;
        }
    }

    return false;
};
// @lc code=end

