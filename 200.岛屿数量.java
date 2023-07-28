/*
 * @lc app=leetcode.cn id=200 lang=java
 *
 * [200] 岛屿数量
 */

// @lc code=start
class Solution {

    int m;
    int n;

    public int numIslands(char[][] grid) {
        // DFS 遍历每一个坐标，当第一次遇到陆地，
        // 就记录岛屿+1，并且把相邻的陆地都标记为海水（将当前岛屿淹了，避免重复计算）
        // 当把当前岛屿淹掉之后，再继续遍历下一个坐标
        // 遍历坐标使用两层for循环

        int res = 0;

        m = grid.length;
        n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    res ++;
                    dfs(grid, i, j);
                }
            }
        }
        return res;
    }

    // 将指定点的陆地变为海水，如果已经是海水了则不操作直接返回
    private void dfs(char[][] grid, int x, int y) {
        if (x < 0 || y < 0 || x >= m || y >= n) {
            return;
        }
        // 防止重复的判断，如果是海水就退出，因为这个方法是检测陆地的
        if (grid[x][y] == '0') {
            return;
        }
        grid[x][y] = '0';
        
        // 将附近的陆地变为海水
        dfs(grid, x - 1, y);
        dfs(grid, x + 1, y);
        dfs(grid, x, y - 1);
        dfs(grid, x, y + 1);
    }
}
// @lc code=end

