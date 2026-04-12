/*
 * @lc app=leetcode.cn id=1091 lang=java
 *
 * [1091] 二进制矩阵中的最短路径
 */

// @lc code=start
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        
        int n = grid.length;
        
        // 起点或终点是1，直接不通
        if (grid[0][0] != 0 || grid[n - 1][n - 1] != 0) {
            return -1;
        }

        // 8个方向
        int[][] dirs = {
            {0,1}, {1,0}, {0,-1}, {-1,0},
            {1,1}, {1,-1}, {-1,1}, {-1,-1}
        };

        Queue<int[]> queue = new LinkedList<>();
        
        // 加入起点 (x, y, 距离)
        queue.offer(new int[]{0, 0, 1});
        
        // 标记访问（直接改grid）
        grid[0][0] = 1;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0], y = cur[1], dist = cur[2];

            // 到终点了
            if (x == n - 1 && y == n - 1) {
                return dist;
            }

            // 遍历8个方向
            for (int[] d : dirs) {
                int nx = x + d[0];
                int ny = y + d[1];

                // 边界 + 可走 + 未访问
                if (nx >= 0 && ny >= 0 && nx < n && ny < n && grid[nx][ny] == 0) {
                    queue.offer(new int[]{nx, ny, dist + 1});
                    grid[nx][ny] = 1; // 标记已访问
                }
            }
        }

        return -1;
    }
}
// @lc code=end

