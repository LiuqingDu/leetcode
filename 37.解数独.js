/*
 * @lc app=leetcode.cn id=37 lang=javascript
 *
 * [37] 解数独
 */

// @lc code=start
/**
 * @param {character[][]} board
 * @return {void} Do not return anything, modify board in-place instead.
 */
var solveSudoku = function(board) {

    let isValid = function(board, x, y, c) {
        for (let i = 0; i < 9; i++) {
            if (board[x][i] == c) {
                return false;
            }
            if (board[i][y] == c) {
                return false;
            }
        }

        for (let i = Math.floor(x / 3) * 3; i <= Math.floor(x / 3) * 3 + 2; i++) {
            for (let j = Math.floor(y / 3) * 3; j <= Math.floor(y / 3) * 3 + 2; j++) {
                if (board[i][j] == c) {
                    return false;
                }
            }
        }

        return true;
    }

    let backtrack = function(board, x, y) {
        if (x === 9) {
            return backtrack(board, 0, y + 1);
        }

        if (y === 9) {
            return true;
        }

        if (board[x][y] !== '.') {
            return backtrack(board, x + 1, y);
        }

        for (let c = '1'; c <= '9'; c++) {
            if (!isValid(board, x, y, c)) {
                continue;
            }
            board[x][y] = "" + c;
            if (backtrack(board, x + 1, y)) {
                return true;
            }
            board[x][y] = '.';
        }
        return false;
    }

    backtrack(board, 0, 0);
};
// @lc code=end

