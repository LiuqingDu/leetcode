/*
 * @lc app=leetcode.cn id=1905 lang=java
 *
 * [1905] 统计子岛屿
 */

// @lc code=start
class Solution {
    // 如果一个格子在grid2是陆地，在grid1是海水，那么它对应的grid2的那片岛屿就不是子岛屿
    // 把grid2里的所有非子岛屿淹掉，那么剩下的岛屿就是子岛屿了

    int m;
    int n;
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        m = grid1.length;
        n = grid1[0].length;

        // 如果grid2是陆地，grid1是海水，那么这里就不是子岛屿，淹掉
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid1[i][j] == 0 && grid2[i][j] == 1) {
                    drown(grid2, i, j);
                }
            }
        }

        int res = 0;
        // 剩下的grid2里面就只有子岛屿了，计算一下数量
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid2[i][j] == 1) {
                    res++;
                    drown(grid2, i, j);
                }
            }
        }
        return res;
    }

    private void drown(int[][] grid, int x, int y) {
        if (x < 0 || x >= m || y < 0 || y >= n) {
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

