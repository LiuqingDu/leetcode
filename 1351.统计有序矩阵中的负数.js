/*
 * @lc app=leetcode.cn id=1351 lang=javascript
 *
 * [1351] 统计有序矩阵中的负数
 */

// @lc code=start
/**
 * @param {number[][]} grid
 * @return {number}
 */
var countNegatives = function(grid) {
    let m = grid.length;
    let n = grid[0].length;
    let res = 0;
    let col = 0;

    for (let row = m - 1; row >= 0; row--) {
        while (col < n && grid[row][col] >= 0) {
            col++;
        }
        res += (n - col);
    }

    return res;
};
// @lc code=end

