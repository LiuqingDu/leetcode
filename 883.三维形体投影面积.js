/*
 * @lc app=leetcode.cn id=883 lang=javascript
 *
 * [883] 三维形体投影面积
 */

// @lc code=start
/**
 * @param {number[][]} grid
 * @return {number}
 */
var projectionArea = function(grid) {
    let area1 = 0, area2 = 0, area3 = 0;
    let n = grid.length;
    for (let i = 0; i < n; i++) {
        let a = 0, b = 0;
        for (let j = 0; j < n; j++) {
            if (grid[i][j] > 0) {
                area1++;
            }
            a = Math.max(a, grid[i][j]);
            b = Math.max(b, grid[j][i]);
        }
        area2 += a;
        area3 += b;
    }
    return area1 + area2 + area3;
};
// @lc code=end

