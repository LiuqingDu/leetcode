/*
 * @lc app=leetcode.cn id=200 lang=javascript
 *
 * [200] 岛屿数量
 */

// @lc code=start
/**
 * @param {character[][]} grid
 * @return {number}
 */
var numIslands = function(grid) {
    
    let drawn = function(grid, x, y) {
        let m = grid.length;
        let n = grid[0].length;

        if (x < 0 || x >= m || y < 0 || y >= n) {
            return;
        }

        if (grid[x][y] == '0') {
            return;
        }

        grid[x][y] = 0;
        drawn(grid, x - 1, y);
        drawn(grid, x + 1, y);
        drawn(grid, x, y - 1);
        drawn(grid, x, y + 1);
    }

    let m = grid.length;
    let n = grid[0].length;
    let res = 0;

    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            if (grid[i][j] == '1') {
                res++;
                drawn(grid, i, j);
            }
        }
    }

    return res;
};
// @lc code=end

