/*
 * @lc app=leetcode.cn id=289 lang=java
 *
 * [289] 生命游戏
 */

// @lc code=start
class Solution {
    public void gameOfLife(int[][] board) {

        // 自定义几个新状态，-1表示之前是活的，新状态是死的，
        // 2表示之前是死的，新状态是活的

        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int live = 0;

                for (int offsetX = -1; offsetX <= 1; offsetX++) {
                    for (int offsetY = -1; offsetY <= 1; offsetY++) {
                        if (!(offsetX == 0 && offsetY == 0)) {
                            int x = i + offsetX;
                            int y = j + offsetY;

                            if (x >= 0 && x < m && y >= 0 && y < n && (board[x][y] == 1 || board[x][y] == -1)) {
                                live ++;
                            }
                        }
                    }
                }

                if (board[i][j] == 1 && (live < 2 || live > 3)) {
                    board[i][j] = -1;
                }
                if (board[i][j] == 0 && live == 3) {
                    board[i][j] = 2;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] >= 1) {
                    board[i][j] = 1;
                }
                if (board[i][j] <= 0) {
                    board[i][j] = 0;
                }
            }
        }
    }
}
// @lc code=end

