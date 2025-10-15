/*
 * @lc app=leetcode.cn id=2319 lang=java
 *
 * [2319] 判断矩阵是否是一个 X 矩阵
 */

// @lc code=start
class Solution {
    public boolean checkXMatrix(int[][] grid) {
        int n = grid.length; // 矩阵大小 n x n

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 判断是否在主对角线或副对角线上
                boolean isDiagonal = (i == j) || (i + j == n - 1);

                if (isDiagonal) {
                    // 对角线元素必须非 0
                    if (grid[i][j] == 0) {
                        return false;
                    }
                } else {
                    // 非对角线元素必须是 0
                    if (grid[i][j] != 0) {
                        return false;
                    }
                }
            }
        }
        return true; // 全部检查通过，返回 true
    }
}
// @lc code=end

