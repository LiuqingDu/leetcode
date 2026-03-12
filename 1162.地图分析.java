/*
 * @lc app=leetcode.cn id=1162 lang=java
 *
 * [1162] 地图分析
 */

// @lc code=start
class Solution {
    public int maxDistance(int[][] grid) {
        
        int n = grid.length;
        Queue<int[]> queue = new LinkedList<>();

        // 1. 把所有陆地加入队列
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        // 特殊情况
        if (queue.isEmpty() || queue.size() == n * n) {
            return -1;
        }

        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        int dist = -1;

        // 2. BFS
        while (!queue.isEmpty()) {
            int size = queue.size();
            dist++;

            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();

                for (int[] d : dirs) {
                    int x = cur[0] + d[0];
                    int y = cur[1] + d[1];

                    if (x >= 0 && x < n && y >= 0 && y < n && grid[x][y] == 0) {
                        grid[x][y] = 1;
                        queue.offer(new int[]{x, y});
                    }
                }
            }
        }

        return dist;
    }
}
// @lc code=end

