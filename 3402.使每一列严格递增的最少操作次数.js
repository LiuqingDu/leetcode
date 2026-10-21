/*
 * @lc app=leetcode.cn id=3402 lang=javascript
 *
 * [3402] 使每一列严格递增的最少操作次数
 */

// @lc code=start
/**
 * @param {number[][]} grid
 * @return {number}
 */
var minimumOperations = function(grid) {
    let res = 0;
    let col = grid[0].length;
    let row = grid.length;

    for (let i = 0; i < col; i++) {
        let pre = grid[0][i];
        for (let j = 1; j < row; j++) {
            res += Math.max(0, (pre + 1) - grid[j][i]);
            pre = Math.max(pre + 1, grid[j][i]);
        }
    }
    return res;
};
// @lc code=end

