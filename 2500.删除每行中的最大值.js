/*
 * @lc app=leetcode.cn id=2500 lang=javascript
 *
 * [2500] 删除每行中的最大值
 */

// @lc code=start
/**
 * @param {number[][]} grid
 * @return {number}
 */
var deleteGreatestValue = function(grid) {
    const m = grid.length, n = grid[0].length;
    for (let i = 0; i < m; i++) {
        grid[i].sort((a, b) => a - b);
    }
    let res = 0;
    for (let j = 0; j < n; j++) {
        let mx = 0;
        for (let i = 0; i < m; i++) {
            mx = Math.max(mx, grid[i][j]);
        }
        res += mx;
    }
    return res;
};
// @lc code=end

