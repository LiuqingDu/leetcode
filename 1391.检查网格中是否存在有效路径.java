/*
 * @lc app=leetcode.cn id=1391 lang=java
 *
 * [1391] 检查网格中是否存在有效路径
 */

// @lc code=start
class Solution {
    // 1. 定义 1~6 号街道的移动方向
    // 为了和题目 1-6 对应，我们让下标 0 留空，用 3 维数组存储 [dx, dy] 两个方向
    private final int[][][] dirs = {
        {},                               // 0 空置
        {{0, -1}, {0, 1}},                // 1: 左, 右
        {{-1, 0}, {1, 0}},                // 2: 上, 下
        {{0, -1}, {1, 0}},                // 3: 左, 下
        {{0, 1},  {1, 0}},                // 4: 右, 下
        {{0, -1}, {-1, 0}},               // 5: 左, 上
        {{0, 1},  {-1, 0}}                // 6: 右, 上
    };

    public boolean hasValidPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        // 访问标记数组，防止死循环
        boolean[][] visited = new boolean[m][n];
        
        // BFS 队列，存储坐标 [row, col]
        Queue<int[]> queue = new LinkedList<>();
        
        // 从 (0,0) 出发
        queue.offer(new int[]{0, 0});
        visited[0][0] = true;
        
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];
            
            // 如果到达右下角，大功告成！
            if (r == m - 1 && c == n - 1) {
                return true;
            }
            
            // 获取当前格子的街道类型
            int streetType = grid[r][c];
            
            // 尝试从当前格子的两个开口走出去
            for (int[] dir : dirs[streetType]) {
                int nextR = r + dir[0];
                int nextC = c + dir[1];
                
                // 1. 检查边界条件和是否访问过
                if (nextR >= 0 && nextR < m && nextC >= 0 && nextC < n && !visited[nextR][nextC]) {
                    // 2. 核心：检查下一个格子是否能和当前格子“接上”
                    if (canConnect(grid, nextR, nextC, r, c)) {
                        visited[nextR][nextC] = true;
                        queue.offer(new int[]{nextR, nextC});
                    }
                }
            }
        }
        
        // 队列空了还没到终点，说明走不通
        return false;
    }
    
    /**
     * 辅助函数：判断目标格子 (nextR, nextC) 是否有开口通往出发点 (fromR, fromC)
     */
    private boolean canConnect(int[][] grid, int nextR, int nextC, int fromR, int fromC) {
        int nextType = grid[nextR][nextC];
        // 遍历目标格子的两个开口
        for (int[] dir : dirs[nextType]) {
            // 如果目标格子的某个开口算出来的坐标刚好是出发点，说明接通了！
            if (nextR + dir[0] == fromR && nextC + dir[1] == fromC) {
                return true;
            }
        }
        return false;
    }
}
// @lc code=end

