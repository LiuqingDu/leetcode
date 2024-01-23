/*
 * @lc app=leetcode.cn id=1020 lang=javascript
 *
 * [1020] 飞地的数量
 */

// @lc code=start
/**
 * @param {number[][]} grid
 * @return {number}
 */
var numEnclaves = function(grid) {

    let drawn = function(grid, x, y) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) {
            return;
        }
        if (grid[x][y] === 1) {
            grid[x][y] = 0;
            drawn(grid, x - 1, y);
            drawn(grid, x + 1, y);
            drawn(grid, x, y - 1);
            drawn(grid, x, y + 1);
        }
    }

    let m = grid.length;
    let n = grid[0].length;

    for (let i = 0; i < m; i++) {
        drawn(grid, i, 0);
        drawn(grid, i, n - 1);
    }

    for (let j = 0; j < n; j++) {
        drawn(grid, 0, j);
        drawn(grid, m - 1, j);
    }

    let res = 0;
    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            if (grid[i][j] === 1) {
                res++;
            }
        }
    }

    return res;

};
// @lc code=end

