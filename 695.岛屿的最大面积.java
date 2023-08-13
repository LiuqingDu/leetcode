/*
 * @lc app=leetcode.cn id=695 lang=java
 *
 * [695] 岛屿的最大面积
 */

// @lc code=start
class Solution {
    // 类似有一题是计算有多少个岛屿
    // 思路是遍历每个格子，当发现是陆地的时候就把这块地淹了，然后遍历这块陆地的上下左右继续淹陆地
    // 这道题在此基础上是计算最大面积，那么可以在淹陆地的时候把面积记为1，然后再加上上下左右四个方向的面积即可
    // 最后维护一个最大值即可

    int m, n;
    int[][] grid;
    // 记录最大值
    int max;
    public int maxAreaOfIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        this.grid = grid;
        // 遍历每一个格子，找到其中每一块陆地
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 计算这个格子所在陆地的面积
                int size = drown(i, j);
                max = Math.max(max, size);
            }
        }
        return max;
    }

    // 如果给定的坐标是陆地就把陆地淹了并记录面积
    private int drown(int x, int y) {
        // 如果超出了边界，或者这个点不是陆地，那么陆地面积记为0
        if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] == 0) {
            return 0;
        }

        // 如果是陆地则记录面积为1，然后再加上上下左右四个方向的陆地面积
        if (grid[x][y] == 1) {
            grid[x][y] = 0;
            int up = drown(x - 1, y);
            int down = drown(x + 1, y);
            int left = drown(x, y - 1);
            int right = drown(x, y + 1);
            return up + down + left + right + 1;
        }

        // 不会有其他的情况，默认返回0
        else {
            return 0;
        }
    }
}
// @lc code=end

