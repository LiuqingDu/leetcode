/*
 * @lc app=leetcode.cn id=529 lang=java
 *
 * [529] 扫雷游戏
 */

// @lc code=start
class Solution {

    int[] dirX = {0, 1, 0, -1, 1, 1, -1, -1};
    int[] dirY = {1, 0, -1, 0, 1, -1, 1, -1};

    public char[][] updateBoard(char[][] board, int[] click) {
        // 直接按照题意模拟
        int x = click[0], y = click[1];
        if (board[x][y] == 'M') {
            // 规则 1, 游戏结束
            board[x][y] = 'X';
        } else{
            dfs(board, x, y);
        }
        return board;
        
    }

    public void dfs(char[][] board, int x, int y) {
        // 计算周围多少个地雷
        int cnt = 0;
        for (int i = 0; i < 8; ++i) {
            int tx = x + dirX[i];
            int ty = y + dirY[i];
            // 如果超出棋盘范围则跳过
            if (tx < 0 || tx >= board.length || ty < 0 || ty >= board[0].length) {
                continue;
            }
            // 统计周围多少个雷
            if (board[tx][ty] == 'M') {
                ++cnt;
            }
        }
        if (cnt > 0) {
            // 规则 3
            board[x][y] = (char) (cnt + '0');
        } else {
            // 规则 2
            // 先标记当前格子, 避免递归旁边的格子的时候又重复再递归当前格子
            board[x][y] = 'B';
            for (int i = 0; i < 8; ++i) {
                int tx = x + dirX[i];
                int ty = y + dirY[i];
                // 排除棋盘范围外的坐标, 也排除不是空格 E 的格子
                if (tx < 0 || tx >= board.length || ty < 0 || ty >= board[0].length || board[tx][ty] != 'E') {
                    continue;
                }
                // 对于棋盘内,且是空格 E 的进行递归处理
                dfs(board, tx, ty);
            }
        }
    }
}
// @lc code=end

