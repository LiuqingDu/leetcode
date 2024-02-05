/*
 * @lc app=leetcode.cn id=36 lang=java
 *
 * [36] 有效的数独
 */

// @lc code=start
class Solution {
    public boolean isValidSudoku(char[][] board) {

        for (int i = 0; i < 9; i++) {
            if (!isValid(board, i, 0, i, 8)) {
                return false;
            }
            if (!isValid(board, 0, i, 8, i)) {
                return false;
            }

            if (!isValid(board, i / 3 * 3, (i % 3) * 3, (i / 3) * 3 + 2, (i % 3) * 3 + 2)) {
                return false;
            }
        }

        return true;

    }

    private boolean isValid(char[][] board, int x1, int y1, int x2, int y2) {
        boolean[] mark = new boolean[9];

        for (int x = x1; x <= x2; x++) {
            for (int y = y1; y <= y2; y++) {
                char c = board[x][y];
                if (c >= '1' && c <= '9') {
                    if (mark[c - '1']) {
                        return false;
                    } else {
                        mark[c - '1'] = true;
                    }
                }
            }
        }

        return true;
    }
}
// @lc code=end

