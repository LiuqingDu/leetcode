/*
 * @lc app=leetcode.cn id=1254 lang=java
 *
 * [1254] 统计封闭岛屿的数目
 */

// @lc code=start
class Solution {
    // 其实就是在200题计算岛屿数量的基础上，排除掉那些跟边缘接触的岛屿，剩下的岛屿就是封闭岛屿
    // 先把边缘是陆地的那些岛屿淹掉，剩下的岛屿就是封闭岛屿
    // 注意这道题跟其它题不一样的是，这里1是海水，0是陆地
    int m;
    int n;
    public int closedIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int res = 0;

        // 先把在边缘的陆地淹掉
        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 0) {
                drown(grid, i, 0);
            }
            if (grid[i][n - 1] == 0) {
                drown(grid, i, n - 1);
            }
        }
        for (int i = 0; i < n; i++) {
            if (grid[0][i] == 0) {
                drown(grid, 0, i);
            }
            if (grid[m - 1][i] == 0) {
                drown(grid, m - 1, i);
            }
        }

        // 剩下的就是封闭岛屿
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    res++;
                    drown(grid, i, j);
                }
            }
        }

        return res;
    }

    private void drown(int[][] grid, int x, int y) {
        if (x < 0 || x >=m || y < 0 || y >= n) {
            return;
        }
        // 这道题1是海水
        if (grid[x][y] == 1) {
            return;
        }
        grid[x][y] = 1;
        drown(grid, x - 1, y);
        drown(grid, x + 1, y);
        drown(grid, x, y - 1);
        drown(grid, x, y + 1);
    }
}
// @lc code=end

