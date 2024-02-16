/*
 * @lc app=leetcode.cn id=63 lang=javascript
 *
 * [63] 不同路径 II
 */

// @lc code=start
/**
 * @param {number[][]} obstacleGrid
 * @return {number}
 */
var uniquePathsWithObstacles = function(obstacleGrid) {
    
    let m = obstacleGrid.length;
    let n = obstacleGrid[0].length;

    if (obstacleGrid[m - 1][n - 1] === 1) {
        return 0;
    }

    let dp = Array.from(Array(m), () => Array(n).fill(0));

    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            if (i === 0 && j === 0) {
                dp[i][j] = 1;
            } else {
                let top = 0;
                let left = 0;
                if (i !== 0 && obstacleGrid[i - 1][j] !== 1) {
                    top = dp[i - 1][j];
                }
                if (j !== 0 && obstacleGrid[i][j - 1] !== 1) {
                    left = dp[i][j - 1];
                }
                dp[i][j] = top + left;
            }
        }
    }

    return dp[m - 1][n - 1];
};
// @lc code=end

