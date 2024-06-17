/*
 * @lc app=leetcode.cn id=463 lang=java
 *
 * [463] 岛屿的周长
 */

// @lc code=start
class Solution {
    public int islandPerimeter(int[][] grid) {
        // dfs
        // 因为只有一个岛，找到任意一块陆地就可以开始
        // 如果邻居是边界之外，或者是水，那么这条边就应该被计算上
        // 如果是陆地，那么这条边不计入，然后需要顺着这块陆地继续遍历
        // 为防止重复访问陆地，把访问过的记为2，遇到2就直接返回0

        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[0].length; y++) {
                if (grid[x][y] == 1) {
                    return dfs(grid, x, y);
                }
            }
        }
        return 0;
    }
    
    private int dfs(int[][] grid, int x, int y) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) {
            return 1;
        }
        if (grid[x][y] == 0) {
            return 1;
        }
        if (grid[x][y] == 2) {
            return 0;
        }
        // 标记这块陆地已经访问过
        grid[x][y] = 2;
        return dfs(grid, x - 1, y)
             + dfs(grid, x + 1, y)
             + dfs(grid, x, y - 1)
             + dfs(grid, x, y + 1);
    }
}
// @lc code=end

