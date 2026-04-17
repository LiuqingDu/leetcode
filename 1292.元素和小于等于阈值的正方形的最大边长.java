/*
 * @lc app=leetcode.cn id=1292 lang=java
 *
 * [1292] 元素和小于等于阈值的正方形的最大边长
 */

// @lc code=start
class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        
        int m = mat.length;
        int n = mat[0].length;

        // 1. 构建前缀和
        int[][] pre = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                pre[i][j] = mat[i - 1][j - 1]
                          + pre[i - 1][j]
                          + pre[i][j - 1]
                          - pre[i - 1][j - 1];
            }
        }

        int maxLen = 0;

        // 2. 枚举边长
        for (int len = 1; len <= Math.min(m, n); len++) {
            boolean found = false;

            for (int i = len; i <= m; i++) {
                for (int j = len; j <= n; j++) {

                    int sum = pre[i][j]
                            - pre[i - len][j]
                            - pre[i][j - len]
                            + pre[i - len][j - len];

                    if (sum <= threshold) {
                        found = true;
                        break;
                    }
                }
                if (found) break;
            }

            if (found) {
                maxLen = len;
            } else {
                break; // 后面更大肯定不行
            }
        }

        return maxLen;
    }
}
// @lc code=end

