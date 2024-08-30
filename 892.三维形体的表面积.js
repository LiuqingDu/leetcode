/*
 * @lc app=leetcode.cn id=892 lang=javascript
 *
 * [892] 三维形体的表面积
 */

// @lc code=start
/**
 * @param {number[][]} grid
 * @return {number}
 */
var surfaceArea = function(grid) {
    let m = grid.length;
    let n = grid[0].length;
    let res = 0;
    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            let stacks = grid[i][j];
            if (stacks > 0) {
                res += stacks * 4 + 2;
                if (i > 0) {
                    res -= Math.min(stacks, grid[i - 1][j]) * 2
                }
                if (j > 0) {
                    res -= Math.min(stacks, grid[i][j - 1]) * 2;
                }
            }
        }
    }
    return res;
};
// @lc code=end

