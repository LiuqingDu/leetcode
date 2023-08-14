/*
 * @lc app=leetcode.cn id=1020 lang=java
 *
 * [1020] 飞地的数量
 */

// @lc code=start
class Solution {
    // 这道题跟1254统计封闭岛屿数量有点类似，那道题是把跟边缘接触的岛淹掉，剩下的是封闭岛屿
    // 这道题，如果岛屿跟边缘接触，那么就可以走出去，不能走出去的也就是这些封闭岛屿
    // 在那道题基础上再计算一下格子数量就可以了

    int m;
    int n;
    public int numEnclaves(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        for (int i = 0; i < m; i++) {
            // 这里的两个 if 可以不要，直接调用两次drown()，因为if判断逻辑跟drown里的相同
            // if (grid[i][0] == 1) {
                drown(grid, i, 0);
            // }
            // if (grid[i][n - 1] == 1) {
                drown(grid, i, n - 1);
            // }
        }
        for (int i = 0; i < n; i++) {
            // if (grid[0][i] == 1) {
                drown(grid, 0, i);
            // }
            // if (grid[m - 1][i] == 1) {
                drown(grid, m - 1, i);
            // }
        }

        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    res++;
                }
            }
        }
        return res;
    }

    // 淹掉陆地
    private void drown(int[][] grid, int x, int y) {
        if (x < 0 || x >=m || y < 0 || y >= n) {
            return;
        }
        if (grid[x][y] == 0) {
            return;
        }

        grid[x][y] = 0;
        drown(grid, x - 1, y);
        drown(grid, x + 1, y);
        drown(grid, x, y - 1);
        drown(grid, x, y + 1);
    }
}
// @lc code=end

