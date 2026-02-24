/*
 * @lc app=leetcode.cn id=2965 lang=javascript
 *
 * [2965] 找出缺失和重复的数字
 */

// @lc code=start
/**
 * @param {number[][]} grid
 * @return {number[]}
 */
var findMissingAndRepeatedValues = function(grid) {
    const n = grid.length;
    const count = new Array(n * n).fill(0);
    for (let i = 0; i < n; i++) {
        for (let j = 0; j < n; j++) {
            count[grid[i][j] - 1]++;
        }
    }

    const res = [];
    for (let i = 0; i < n * n; i++) {
        if (count[i] === 0) {
            res[1] = i + 1;
        } else if (count[i] === 2) {
            res[0] = i + 1;
        }
    }
    return res;
};
// @lc code=end

