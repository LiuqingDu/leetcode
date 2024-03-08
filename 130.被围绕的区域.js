/*
 * @lc app=leetcode.cn id=130 lang=javascript
 *
 * [130] 被围绕的区域
 */

// @lc code=start
/**
 * @param {character[][]} board
 * @return {void} Do not return anything, modify board in-place instead.
 */
var solve = function(board) {

    let m = board.length;
    let n = board[0].length;

    let drawn = function(board, x, y, a, b) {
        if (x < 0 || x >= m || y < 0 || y >= n) {
            return;
        }
        if (board[x][y] === a) {
            board[x][y] = b;
            drawn(board, x - 1, y, a, b);
            drawn(board, x + 1, y, a, b);
            drawn(board, x, y - 1, a, b);
            drawn(board, x, y + 1, a, b);
        }
    }

    for (let i = 0; i < m; i++) {
        drawn(board, i, 0, 'O', 'Y');
        drawn(board, i, n - 1, 'O', 'Y');
    }
    for (let j = 0; j < n; j++) {
        drawn(board, 0, j, 'O', 'Y');
        drawn(board, m - 1, j, 'O', 'Y');
    }

    for (let i = 1; i < m - 1; i++) {
        for (let j = 1; j < n - 1; j++) {
            drawn(board, i, j, 'O', 'X');
        }
    }

    for (let i = 0; i < m; i++) {
        drawn(board, i, 0, 'Y', 'O');
        drawn(board, i, n - 1, 'Y', 'O');
    }
    for (let j = 0; j < n; j++) {
        drawn(board, 0, j, 'Y', 'O');
        drawn(board, m - 1, j, 'Y', 'O');
    }

};
// @lc code=end

