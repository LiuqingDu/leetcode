/*
 * @lc app=leetcode.cn id=542 lang=java
 *
 * [542] 01 矩阵
 */

// @lc code=start
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        // 可以看出如果格子内是 0,则距离也是 0
        // 如果格子内是 1,则最小距离取决于上下左右四个方向的最小值
        // 类似的题目是从顶部出发经过格子的分值能否到达底部
        // 那种题目是有一个固定的方向,比如从上到下,从左上到右下
        // 本题是需要考虑四个方向
        // 可以从左上到右下,然后从右下到左上,这样就不会遗漏四个方向

        int m = mat.length;
        int n = mat[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    dp[i][j] = 0;
                } else {
                    // 题目中因为 m*n <= 10^4
                    // 那么 m+n <= 10^4
                    // 这里不能用 maxvalue 因为后续 +1 会溢出
                    dp[i][j] = 10000;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i][j] != 0) {
                    if (i > 0) {
                        dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + 1);
                    }
                    if (j > 0) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + 1);
                    }
                }
            }
        }

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (dp[i][j] != 0) {
                    if (i < m - 1) {
                        dp[i][j] = Math.min(dp[i][j], dp[i + 1][j] + 1);
                    }
                    if (j < n - 1) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][j + 1] + 1);
                    }
                }
            }
        }
        return dp;
    }
}
// @lc code=end

