/*
 * @lc app=leetcode.cn id=2923 lang=javascript
 *
 * [2923] 找到冠军 I
 */

// @lc code=start
/**
 * @param {number[][]} grid
 * @return {number}
 */
var findChampion = function(grid) {
    let n = grid.length;
    for (let i = 0; i < n; i++) {
        let sum = 0;
        for (let j = 0; j < n; j++) {
            sum += grid[i][j];
        }

        if (sum === n - 1) {
            return i;
        }
    }
    return -1;
};
// @lc code=end

