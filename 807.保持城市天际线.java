/*
 * @lc app=leetcode.cn id=807 lang=java
 *
 * [807] 保持城市天际线
 */

// @lc code=start
class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        
        int n = grid.length;
        int[] rowMax = new int[n];
        int[] colMax = new int[n];

        // Step 1: 找出每一行和每一列的最大高度
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                rowMax[r] = Math.max(rowMax[r], grid[r][c]);
                colMax[c] = Math.max(colMax[c], grid[r][c]);
            }
        }

        int totalIncrement = 0;

        // Step 2: 计算每个建筑最多能加高多少
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                // 限制它的是“行最大”和“列最大”之中的较小值
                int maxAllowed = Math.min(rowMax[r], colMax[c]);
                // 累加增量
                totalIncrement += maxAllowed - grid[r][c];
            }
        }

        return totalIncrement;
    }
}
// @lc code=end

