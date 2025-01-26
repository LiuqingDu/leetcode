/*
 * @lc app=leetcode.cn id=794 lang=java
 *
 * [794] 有效的井字游戏
 */

// @lc code=start
class Solution {
    public boolean validTicTacToe(String[] board) {
        // 统计 'X' 和 'O' 的数量
        int xCount = 0, oCount = 0;
        for (String row : board) {
            for (char c : row.toCharArray()) {
                if (c == 'X') xCount++;
                else if (c == 'O') oCount++;
            }
        }

        // 'X' 不能少于 'O'，并且 'X' 和 'O' 的差不能超过 1
        if (oCount > xCount || xCount - oCount > 1) {
            return false;
        }

        // 判断 'X' 和 'O' 是否获胜
        boolean xWin = win(board, 'X');
        boolean oWin = win(board, 'O');

        // 如果 'X' 赢了，'X' 的数量必须比 'O' 多 1
        if (xWin && xCount - oCount != 1) {
            return false;
        }

        // 如果 'O' 赢了，'X' 的数量必须等于 'O'
        if (oWin && xCount != oCount) {
            return false;
        }

        // 如果两者同时赢，不可能
        if (xWin && oWin) {
            return false;
        }

        return true;
    }

    // 检查是否某个字符赢了
    private boolean win(String[] board, char player) {
        // 检查行、列和对角线
        for (int i = 0; i < 3; i++) {
            // 检查行
            if (board[i].charAt(0) == player && board[i].charAt(1) == player && board[i].charAt(2) == player) {
                return true;
            }
            // 检查列
            if (board[0].charAt(i) == player && board[1].charAt(i) == player && board[2].charAt(i) == player) {
                return true;
            }
        }
        // 检查对角线
        if (board[0].charAt(0) == player && board[1].charAt(1) == player && board[2].charAt(2) == player) {
            return true;
        }
        if (board[0].charAt(2) == player && board[1].charAt(1) == player && board[2].charAt(0) == player) {
            return true;
        }

        return false;
    }
}
// @lc code=end

