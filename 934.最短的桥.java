/*
 * @lc app=leetcode.cn id=934 lang=java
 *
 * [934] 最短的桥
 */

// @lc code=start
class Solution {
    int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    int n;
    Queue<int[]> queue = new LinkedList<>();

    public int shortestBridge(int[][] grid) {
        n = grid.length;

        // 1. 找到第一个岛
        boolean found = false;
        for (int i = 0; i < n && !found; i++) {
            for (int j = 0; j < n && !found; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j);
                    found = true;
                }
            }
        }

        // 2. BFS 扩展
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                for (int[] d : dirs) {
                    int x = cur[0] + d[0];
                    int y = cur[1] + d[1];

                    if (x < 0 || y < 0 || x >= n || y >= n) continue;

                    if (grid[x][y] == 1) {
                        return step; // 找到第二个岛
                    }

                    if (grid[x][y] == 0) {
                        grid[x][y] = 2;
                        queue.offer(new int[]{x, y});
                    }
                }
            }
            step++;
        }

        return -1;
    }

    // DFS 标记第一个岛
    private void dfs(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= n || j >= n || grid[i][j] != 1) return;

        grid[i][j] = 2;
        queue.offer(new int[]{i, j});

        for (int[] d : dirs) {
            dfs(grid, i + d[0], j + d[1]);
        }
    }
}
// @lc code=end

