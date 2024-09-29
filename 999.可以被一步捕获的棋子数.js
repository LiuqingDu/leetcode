/*
 * @lc app=leetcode.cn id=999 lang=javascript
 *
 * [999] 可以被一步捕获的棋子数
 */

// @lc code=start
/**
 * @param {character[][]} board
 * @return {number}
 */
var numRookCaptures = function(board) {
    let dx = [-1, 1, 0, 0];
    let dy = [0, 0, -1, 1];
    
    let a = 0, b = 0;

    for (let i = 0; i < 8; i++) {
        for (let j = 0; j < 8; j++) {
            if (board[i][j] === "R") {
                a = i;
                b = j;
            }
        }
    }

    let res = 0;
    for (let i = 0; i < 4; i++) {
        let x = a, y = b;
        while (true) {
            x += dx[i];
            y += dy[i];

            if (x < 0 || x >= 8 || y < 0 || y >= 8) {
                break;
            }
            if (board[x][y] === "p") {
                res++;
                break;
            }
            if (board[x][y] === "B") {
                break;
            }
        }
    }

    return res;
};
// @lc code=end

