/*
 * @lc app=leetcode.cn id=1260 lang=javascript
 *
 * [1260] 二维网格迁移
 */

// @lc code=start
/**
 * @param {number[][]} grid
 * @param {number} k
 * @return {number[][]}
 */
var shiftGrid = function(grid, k) {
    const m = grid.length, n = grid[0].length;
    const ret = Array.from({ length: m }, () => Array(n).fill(0));
    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            const index1 = (i * n + j + k) % (m * n);
            ret[Math.floor(index1 / n)][index1 % n] = grid[i][j];
        }
    }
    return ret;
};
// @lc code=end

