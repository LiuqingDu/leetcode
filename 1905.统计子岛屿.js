/*
 * @lc app=leetcode.cn id=1905 lang=javascript
 *
 * [1905] 统计子岛屿
 */

// @lc code=start
/**
 * @param {number[][]} grid1
 * @param {number[][]} grid2
 * @return {number}
 */
var countSubIslands = function(grid1, grid2) {

    let drawn = function(grid, x, y) {
        let m = grid.length;
        let n = grid[0].length;
        if (x < 0 || x >= m || y < 0 || y >= n) {
            return;
        }

        if (grid[x][y] === 0) {
            return;
        }

        grid[x][y] = 0;

        drawn(grid, x - 1, y);
        drawn(grid, x + 1, y);
        drawn(grid, x, y - 1);
        drawn(grid, x, y + 1);
    }

    let m = grid1.length;
    let n = grid1[0].length;

    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            if (grid2[i][j] === 1 && grid1[i][j] === 0) {
                drawn(grid2, i, j);
            }
        }
    }

    let res = 0;

    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            if (grid2[i][j] === 1) {
                res++;
                drawn(grid2, i, j);
            }
        }
    }

    return res;

};
// @lc code=end

