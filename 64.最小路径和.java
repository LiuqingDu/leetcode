/*
 * @lc app=leetcode.cn id=64 lang=java
 *
 * [64] 最小路径和
 */

// @lc code=start
class Solution {
    // 每次只能往下或者往右移动，那么给定的一个格子，
    // 它的最小路径就是上面的格子和左边的格子的最小路径再加自己的值
    // 而最上面一行和最左边一行的格子，它们的最小路径就是到它们的直线路径
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        // 新建一个数组用于存储每个格子的最小路径
        int[][] res = new int[m][n];

        // 左上角第一个格子的最小路径就是它自己
        res[0][0] = grid[0][0];
        // 依次把最上面一行和最左边一行填充上，它们的值等于左上角到它们自己的直线路径之和
        for (int i = 1; i < m; i++) {
            res[i][0] = res[i-1][0] + grid[i][0];
        }
        for (int i = 1; i < n; i++) {
            res[0][i] = res[0][i - 1] + grid[0][i];
        }

        // 剩下的格子的最小路径取决于左侧格子和上面格子的最小值
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                res[i][j] = Math.min(res[i - 1][j], res[i][j - 1]) + grid[i][j];
            }
        }

        return res[m - 1][n - 1];
    }
}
// @lc code=end

