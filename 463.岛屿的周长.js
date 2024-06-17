/*
 * @lc app=leetcode.cn id=463 lang=javascript
 *
 * [463] 岛屿的周长
 */

// @lc code=start
/**
 * @param {number[][]} grid
 * @return {number}
 */
var islandPerimeter = function(grid) {
    let dfs = function(grid, x, y) {
        let m = grid.length, n = grid[0].length;
        if (x < 0 || x >= m || y < 0 || y >= n) {
            return 1;
        }
        if (grid[x][y] === 0) {
            return 1;
        }
        if (grid[x][y] === 2) {
            return 0;
        }
        grid[x][y] = 2;
        return dfs(grid, x - 1, y)
             + dfs(grid, x + 1, y)
             + dfs(grid, x, y - 1)
             + dfs(grid, x, y + 1);
    }
    
    for (let x = 0; x < grid.length; x++) {
        for (let y = 0; y < grid[0].length; y++) {
            if (grid[x][y] === 1) {
                return dfs(grid, x, y);
            }
        }
    }
    return 0;

};
// @lc code=end

