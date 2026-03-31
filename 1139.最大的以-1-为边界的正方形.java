/*
 * @lc app=leetcode.cn id=1139 lang=java
 *
 * [1139] 最大的以 1 为边界的正方形
 */

// @lc code=start
class Solution {
    public int largest1BorderedSquare(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;

        int[][] right = new int[m][n];
        int[][] down = new int[m][n];

        // 预处理
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (grid[i][j] == 1) {
                    right[i][j] = 1 + (j + 1 < n ? right[i][j + 1] : 0);
                    down[i][j] = 1 + (i + 1 < m ? down[i + 1][j] : 0);
                }
            }
        }

        int maxLen = 0;

        // 枚举左上角
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                // 从大到小试（剪枝）
                for (int k = Math.min(m - i, n - j); k > 0; k--) {

                    if (k <= maxLen) break;

                    if (right[i][j] >= k &&
                        down[i][j] >= k &&
                        right[i + k - 1][j] >= k &&
                        down[i][j + k - 1] >= k) {

                        maxLen = k;
                        break;
                    }
                }
            }
        }

        return maxLen * maxLen;
    }
}
// @lc code=end

