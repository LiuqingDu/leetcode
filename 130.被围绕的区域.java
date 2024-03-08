/*
 * @lc app=leetcode.cn id=130 lang=java
 *
 * [130] 被围绕的区域
 */

// @lc code=start
class Solution {
    int m = 0;
    int n = 0;

    public void solve(char[][] board) {

        m = board.length;
        n = board[0].length;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
                    drawn(board, i, j);
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == 'Y') {
                    board[i][j] = 'O';
                }
            }
        }

    }

    private void drawn(char[][] board, int x, int y) {
        if (x < 0 || x >= m || y < 0 || y >= n) {
            return;
        }
        if (board[x][y] == 'O') {
            board[x][y] = 'Y';
            drawn(board, x - 1, y);
            drawn(board, x + 1, y);
            drawn(board, x, y - 1);
            drawn(board, x, y + 1);
        }
    }
}
// @lc code=end

