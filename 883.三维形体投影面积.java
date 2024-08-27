/*
 * @lc app=leetcode.cn id=883 lang=java
 *
 * [883] 三维形体投影面积
 */

// @lc code=start
class Solution {
    public int projectionArea(int[][] grid) {
        int area1 = 0, area2 = 0, area3 = 0;
        int n = grid.length;
        for (int i = 0; i < n; i++) {
            int a = 0, b = 0;
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > 0) {
                    area1++;
                }
                a = Math.max(a, grid[i][j]);
                b = Math.max(b, grid[j][i]);
            }
            area2 += a;
            area3 += b;
        }
        return area1 + area2 + area3;
    }
}
// @lc code=end

