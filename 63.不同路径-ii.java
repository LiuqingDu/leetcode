/*
 * @lc app=leetcode.cn id=63 lang=java
 *
 * [63] 不同路径 II
 */

// @lc code=start
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        if (obstacleGrid[m - 1][n - 1] == 1) {
            return 0;
        }

        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                } else {
                    int top = 0;
                    int left = 0;
                    if (i != 0 && obstacleGrid[i - 1][j] != 1) {
                        top = dp[i - 1][j];
                    }
                    if (j != 0 && obstacleGrid[i][j - 1] != 1) {
                        left = dp[i][j - 1];
                    }
                    dp[i][j] = top + left;
                }
            }
        }

        return dp[m - 1][n - 1];

    }
}
// @lc code=end

