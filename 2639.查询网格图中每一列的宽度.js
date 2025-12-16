/*
 * @lc app=leetcode.cn id=2639 lang=javascript
 *
 * [2639] 查询网格图中每一列的宽度
 */

// @lc code=start
/**
 * @param {number[][]} grid
 * @return {number[]}
 */
var findColumnWidth = function(grid) {
    const n = grid.length, m = grid[0].length;
    const res = new Array(m).fill(0);
    for (let i = 0; i < n; i++) {
        for (let j = 0; j < m; j++) {
            let x = grid[i][j];
            let length = 0;
            if (x <= 0) {
                length = 1;
            }
            x = Math.abs(x);
            while (x != 0) {
                length += 1;
                x = Math.floor(x / 10);
            }
            res[j] = Math.max(res[j], length);
        }
    }
    return res;
};
// @lc code=end

