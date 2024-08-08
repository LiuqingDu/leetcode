/*
 * @lc app=leetcode.cn id=766 lang=javascript
 *
 * [766] 托普利茨矩阵
 */

// @lc code=start
/**
 * @param {number[][]} matrix
 * @return {boolean}
 */
var isToeplitzMatrix = function(matrix) {
    let compareTwoRow = function(row1, row2) {
        let n = row1.length;
        for (let i = 0; i < n - 1; i++) {
            if (row1[i] !== row2[i + 1]) {
                return false;
            }
        }
        return true;
    }

    let n = matrix.length;
    for (let i = 0; i < n - 1; i++) {
        if (!compareTwoRow(matrix[i], matrix[i + 1])) {
            return false;
        }
    }
    return true;
};
// @lc code=end

