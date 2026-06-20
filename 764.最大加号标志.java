/*
 * @lc app=leetcode.cn id=764 lang=java
 *
 * [764] 最大加号标志
 */

// @lc code=start
class Solution {
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        
        // 1. 将地雷存入哈希表
        Set<Integer> zeroSet = new HashSet<>();
        for (int[] mine : mines) {
            zeroSet.add(mine[0] * n + mine[1]);
        }

        // 2. 初始化 dp 数组，全部填满最大可能的值 n
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], n);
        }

        // 3. 核心：双指针四方向同时扫描
        for (int i = 0; i < n; i++) {
            int left = 0, right = 0, up = 0, down = 0;

            for (int j = 0, k = n - 1; j < n; j++, k--) {
                // 从左往右 (i, j)
                left = zeroSet.contains(i * n + j) ? 0 : left + 1;
                dp[i][j] = Math.min(dp[i][j], left);

                // 从右往左 (i, k)
                right = zeroSet.contains(i * n + k) ? 0 : right + 1;
                dp[i][k] = Math.min(dp[i][k], right);

                // 从上往下 (j, i)
                up = zeroSet.contains(j * n + i) ? 0 : up + 1;
                dp[j][i] = Math.min(dp[j][i], up);

                // 从下往上 (k, i)
                down = zeroSet.contains(k * n + i) ? 0 : down + 1;
                dp[k][i] = Math.min(dp[k][i], down);
            }
        }

        // 4. 找出全网格中的最大阶数
        int maxOrder = 0;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                maxOrder = Math.max(maxOrder, dp[r][c]);
            }
        }

        return maxOrder;
    }
}
// @lc code=end

