/*
 * @lc app=leetcode.cn id=3127 lang=java
 *
 * [3127] 构造相同颜色的正方形
 */

// @lc code=start
class Solution {
    public boolean canMakeSquare(char[][] grid) {
        // 检查每一个格子，以这个格子为起点的 2x2 矩形，
        // 如果这个矩形里是2白2黑，则无法变成同色，否则就可以
        // 只要有一个矩形可以就满足要求

        for (int i = 0; i <= 1; i++) {
            for (int j = 0; j <= 1; j++) {
                if (check(grid, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean check(char[][] grid, int x, int y) {
        int count = 0;
        // i 和 j 表示以当前格子为起点的 2x2 矩形
        // 两轮遍历矩形内的 4 个格子
        for (int i = 0; i <= 1; i++) {
            for (int j = 0; j <= 1; j++) {
                // 如果矩形内的格子是黑色，记录总数
                if (grid[x + i][y + j] == 'B') {
                    count++;
                }
            }
        }
        // 如果数量不为 2 则可以变成同色
        return count != 2;
    }
}
// @lc code=end

