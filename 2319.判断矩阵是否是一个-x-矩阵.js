/*
 * @lc app=leetcode.cn id=2319 lang=javascript
 *
 * [2319] 判断矩阵是否是一个 X 矩阵
 */

// @lc code=start
/**
 * @param {number[][]} grid
 * @return {boolean}
 */
var checkXMatrix = function(grid) {
  const n = grid.length;

  for (let i = 0; i < n; i++) {
    for (let j = 0; j < n; j++) {
      const isDiagonal = (i === j) || (i + j === n - 1);

      if (isDiagonal) {
        if (grid[i][j] === 0) return false;
      } else {
        if (grid[i][j] !== 0) return false;
      }
    }
  }

  return true;
};
// @lc code=end

