/*
 * @lc app=leetcode.cn id=1314 lang=java
 *
 * [1314] 矩阵区域和
 */

// @lc code=start
class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;

        // 1. 前缀和数组
        int[][] pre = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                pre[i][j] = mat[i - 1][j - 1]
                        + pre[i - 1][j]
                        + pre[i][j - 1]
                        - pre[i - 1][j - 1];
            }
        }

        int[][] ans = new int[m][n];

        // 2. 每个点计算 k 范围矩形
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                int r1 = Math.max(0, i - k);
                int c1 = Math.max(0, j - k);
                int r2 = Math.min(m - 1, i + k);
                int c2 = Math.min(n - 1, j + k);

                // 转成前缀和坐标（+1偏移）
                r1++; c1++; r2++; c2++;

                ans[i][j] = pre[r2][c2]
                        - pre[r1 - 1][c2]
                        - pre[r2][c1 - 1]
                        + pre[r1 - 1][c1 - 1];
            }
        }

        return ans;
    }
}
// @lc code=end

