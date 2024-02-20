/*
 * @lc app=leetcode.cn id=74 lang=javascript
 *
 * [74] 搜索二维矩阵
 */

// @lc code=start
/**
 * @param {number[][]} matrix
 * @param {number} target
 * @return {boolean}
 */
var searchMatrix = function(matrix, target) {

    let m = matrix.length;
    let n = matrix[0].length;

    let l = 0;
    let r = m * n - 1;

    while (l <= r) {
        let mid = Math.floor((l + r) / 2);
        let row = Math.floor(mid / n);
        let col = mid % n;
        if (matrix[row][col] < target) {
            l = mid + 1;
        } else if (matrix[row][col] > target) {
            r = mid - 1;
        } else if (matrix[row][col] === target) {
            return true;
        }
    }

    return false;

};
// @lc code=end

