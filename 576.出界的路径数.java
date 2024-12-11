/*
 * @lc app=leetcode.cn id=576 lang=java
 *
 * [576] 出界的路径数
 */

// @lc code=start
class Solution {
    int MOD = (int)1e9+7;
    int m, n;
    int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    int[][][] cache;

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        // 看上去用 dp 可解
        // dp 不太好想
        // 先用 dfs
        // 用 memo 记录避免重复计算

        this.m = m; this.n = n;
        cache = new int[m][n][maxMove + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k <= maxMove; k++) {
                    cache[i][j][k] = -1;
                }
            }
        }
        return dfs(startRow, startColumn, maxMove);
    }

    // 当前坐标是(x,y)的格子上,刚好走 k 步,有多少种方法可以走出去
    private int dfs(int x, int y, int k) {
        if (x < 0 || x >= this.m || y < 0 || y >= this.n) return 1;
        if (k == 0) return 0;
        if (cache[x][y][k] != -1) return cache[x][y][k];
        int ans = 0;
        for (int[] d : dirs) {
            int nx = x + d[0], ny = y + d[1];
            ans += dfs(nx, ny, k - 1);
            ans %= MOD;
        }
        cache[x][y][k] = ans;
        return ans;
    }
}
// @lc code=end

