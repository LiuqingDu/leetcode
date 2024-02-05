/*
 * @lc app=leetcode.cn id=36 lang=javascript
 *
 * [36] 有效的数独
 */

// @lc code=start
/**
 * @param {character[][]} board
 * @return {boolean}
 */
var isValidSudoku = function(board) {

    let isValid = function(board, x1, y1, x2, y2) {
        let mark = Array(9).fill(false);
        for (let x = x1; x <= x2; x++) {
            for (let y = y1; y <= y2; y++) {
                let c = board[x][y];
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

    for (let i = 0; i < 9; i++) {
        if (!isValid(board, i, 0, i, 8)) {
            return false;
        }
        if (!isValid(board, 0, i, 8, i)) {
            return false;
        }
        if (!isValid(board, parseInt(i / 3) * 3, (i % 3) * 3, parseInt(i / 3) * 3 + 2, (i % 3) * 3 + 2)) {
            return false;
        }
    }
    return true;

};
// @lc code=end

