/*
 * @lc app=leetcode.cn id=999 lang=java
 *
 * [999] 可以被一步捕获的棋子数
 */

// @lc code=start
class Solution {
    public int numRookCaptures(char[][] board) {
        // 题目的意思是，从车的位置向任意一个方向出发移动一次，能吃掉卒的方案数
        // 因此 res 最大是 4
        // 代表四个方向有几个方向可以一步吃卒

        // 可以移动的方向
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        // 车的位置
        int a = 0, b = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == 'R') {
                    a = i;
                    b = j;
                }
            }
        }

        int res = 0;
        for (int i = 0; i < 4; i++) {
            // 每轮循环选定一个方向
            int x = a, y = b;
            while (true) {
                // 朝着一个方向走，直到走出棋盘或者有结果
                x += dx[i];
                y += dy[i];
                if (x < 0 || x >= 8 || y < 0 || y >= 8) {
                    break;
                }
                if (board[x][y] == 'p') {
                    res++;
                    break;
                }
                if (board[x][y] == 'B') {
                    break;
                }
            }
        }

        return res;
    }
}
// @lc code=end

