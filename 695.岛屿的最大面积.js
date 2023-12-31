/*
 * @lc app=leetcode.cn id=695 lang=javascript
 *
 * [695] 岛屿的最大面积
 */

// @lc code=start
/**
 * @param {number[][]} grid
 * @return {number}
 */
var maxAreaOfIsland = function(grid) {

    let res = 0;

    let drawn = function(grid, x, y) {
        let m = grid.length;
        let n = grid[0].length;

        if (x < 0 || x >= m || y < 0 || y >= n) {
            return 0;
        }

        if (grid[x][y] === 0) {
            return 0;
        }

        grid[x][y] = 0;
        let s = 1;

        s += drawn(grid, x - 1, y);
        s += drawn(grid, x, y - 1);
        s += drawn(grid, x + 1, y);
        s += drawn(grid, x, y + 1);

        return s;
    }

    let m = grid.length;
    let n = grid[0].length;

    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            if (grid[i][j] === 1) {
                res = Math.max(res, drawn(grid, i, j, 0));
            }
        }
    }

    return res;

};
// @lc code=end

