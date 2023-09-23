/*
 * @lc app=leetcode.cn id=37 lang=java
 *
 * [37] 解数独
 */

// @lc code=start
class Solution {
    // 回溯算法，依次尝试在每个格子填入一个数字，
    // 如果符合要求就跳到下一个格子，如果不符合要求就尝试下一个数字
    // 关键是判断当前数字是否符合要求
    public void solveSudoku(char[][] board) {
        backtrack(board, 0, 0);
    }

    private boolean backtrack(char[][] board, int x, int y) {
        // 如果一行到最右边了，则从下一行开始
        if (y == 9) {
            return backtrack(board, x + 1, 0);
        }
        // 如果最后一行也走完了，走到下边外了，则每个格子都填完了，返回true
        if (x == 9) {
            return true;
        }

        // 如果已经有数字了就跳到下一个格子
        if (board[x][y] != '.') {
            return backtrack(board, x, y + 1);
        }

        // 尝试在当前格子填写数字
        for (char c = '1'; c <= '9'; c++) {
            // 不符合要求的数字就跳过
            if (!isValid(board, x, y, c)) {
                continue;
            }
            // 填上一个符合要求的数字，然后尝试填剩下的
            board[x][y] = c;
            // 如果剩下的格子填完符合要求则直接返回
            if (backtrack(board, x, y + 1)) {
                return true;
            }
            // 否则恢复为没填的状态
            board[x][y] = '.';
        }
        // 所有数字都尝试过了，不满足要求
        return false;
    }

    // 在(x, y)的位置上填入字符c，是否满足要求
    private boolean isValid(char[][] board, int x, int y, char c) {
        for (int i = 0; i < 9; i++) {
            // 判断当前行是否已经存在同样的数字
            if (board[x][i] == c) {
                return false;
            }
            // 判断当前列是否已经存在同样的数字
            if (board[i][y] == c) {
                return false;
            }
            // 判断当前格子所在的3x3区域是否有同样的数字
            // 这段代码不好理解，可以用后面那段
            // if (board[(x/3)*3 + i/3][(y/3)*3 + i%3] == c) {
            //     return false;
            // }
        }
        // 检查3x3区域
        for (int i = x/3*3; i <= x/3*3 + 2; i++) {
            for (int j = y/3*3; j <= y/3*3 + 2; j++) {
                if (board[i][j] == c) {
                    return false;
                }
            }
        }
        // 检查完符合要求
        return true;
    }
}
// @lc code=end

