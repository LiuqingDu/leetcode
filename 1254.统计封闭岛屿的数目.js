/*
 * @lc app=leetcode.cn id=1254 lang=javascript
 *
 * [1254] 统计封闭岛屿的数目
 */

// @lc code=start
/**
 * @param {number[][]} grid
 * @return {number}
 */
var closedIsland = function(grid) {

    let drawn = function(grid, x, y) {
        let m = grid.length;
        let n = grid[0].length;

        if (x < 0 || x >= m || y < 0 || y >= n) {
            return;
        }

        if (grid[x][y] === 1) {
            return;
        }

        grid[x][y] = 1;

        drawn(grid, x - 1, y);
        drawn(grid, x + 1, y);
        drawn(grid, x, y - 1);
        drawn(grid, x, y + 1);
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
            if (grid[i][j] === 0) {
                res++;
                drawn(grid, i, j);
            }
        }
    }

    return res;

};
// @lc code=end

