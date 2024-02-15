/*
 * @lc app=leetcode.cn id=62 lang=java
 *
 * [62] 不同路径
 */

// @lc code=start
class Solution {
    public int uniquePaths(int m, int n) {

        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                } else {
                    int top = 0;
                    int left = 0;
                    if (i != 0) {
                        top = dp[i - 1][j];
                    }
                    if (j != 0) {
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

