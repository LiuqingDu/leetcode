/*
 * @lc app=leetcode.cn id=51 lang=javascript
 *
 * [51] N 皇后
 */

// @lc code=start
/**
 * @param {number} n
 * @return {string[][]}
 */
var solveNQueens = function(n) {

    let queenToBoard = function(queen, n) {
        let board = [];
        for (let i = 0; i < n; i++) {
            let row = Array(n).fill(".");
            row[queen[i]] = 'Q';
            board.push(row.join(""));
        }
        return board;
    }

    let backtrace = function(res, queen, n, row, col, diag1, diag2) {
        if (row === n) {
            let board = queenToBoard(queen, n);
            res.push(board);
            return;
        }

        for (let i = 0; i < n; i++) {
            if (col.has(i)) {
                continue;
            }
            let d1 = row - i;
            if (diag1.has(d1)) {
                continue;
            }
            let d2 = row + i;
            if (diag2.has(d2)) {
                continue;
            }
            queen[row] = i;
            col.add(i);
            diag1.add(d1);
            diag2.add(d2);
            backtrace(res, queen, n, row + 1, col, diag1, diag2);
            diag2.delete(d2);
            diag1.delete(d1);
            col.delete(i);
            queen[row] = -1;
        }
    }

    let res = [];
    let queen = Array(n).fill(-1);
    let col = new Set();
    let diag1 = new Set();
    let diag2 = new Set();
    backtrace(res, queen, n, 0, col, diag1, diag2);
    return res;

};
// @lc code=end

