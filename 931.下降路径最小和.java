/*
 * @lc app=leetcode.cn id=931 lang=java
 *
 * [931] 下降路径最小和
 */

// @lc code=start
class Solution {
    // 动态规划，从顶部往下遍历计算到达每个格子的最小路径和
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];

        // 初始化第一行的值为matrix第一行
        for (int i = 0; i < n; i++) {
            dp[0][i] = matrix[0][i];
        }

        // 剩下的格子初始化为最大值
        for (int i = 1; i < n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        // 从第二行开始往下遍历
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int l = j - 1, r = j + 1;
                // 如果当前格子左上角在边界内，则计算从左上角走过来的路径和，然后取小值
                if (l >= 0) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][l] + matrix[i][j]);
                }
                // 如果当前格子右上角在边界内，则计算从右上角走过来的路径和，然后取小值
                if (r < n) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][r] + matrix[i][j]);
                }
                // 计算从上面格子走过来的路径和，取小值
                dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + matrix[i][j]);
            }
        }

        // 取出最底一行的最小值就是结果
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (dp[n - 1][i] < res) {
                res = dp[n - 1][i];
            }
        }

        return res;

    }
}
// @lc code=end

