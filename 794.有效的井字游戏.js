/*
 * @lc app=leetcode.cn id=794 lang=javascript
 *
 * [794] 有效的井字游戏
 */

// @lc code=start
/**
 * @param {string[]} board
 * @return {boolean}
 */
var validTicTacToe = function(board) {

    const checkWin = function(board, player) {
        for (let i = 0; i < 3; i++) {
            if (board[i][0] === player && board[i][1] === player && board[i][2] === player) {
                return true;
            }
            if (board[0][i] === player && board[1][i] === player && board[2][i] === player) {
                return true;
            }
        }
        if (board[0][0] === player && board[1][1] === player && board[2][2] === player) {
            return true;
        }
        if (board[0][2] === player && board[1][1] === player && board[2][0] === player) {
            return true;
        }

        return false;
    }
    
    let xCount = 0, oCount = 0;

    for (let row of board) {
        for (let char of row) {
            if (char === 'X') xCount++;
            else if (char === 'O') oCount++;
        }
    }

    if (oCount > xCount || xCount - oCount > 1) {
        return false;
    }

    const xWin = checkWin(board, 'X');
    const oWin = checkWin(board, 'O');

    if (xWin && xCount - oCount !== 1) {
        return false;
    }

    if (oWin && xCount !== oCount) {
        return false;
    }

    if (xWin && oWin) {
        return false;
    }

    return true;
};
// @lc code=end

