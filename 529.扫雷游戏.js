/*
 * @lc app=leetcode.cn id=529 lang=javascript
 *
 * [529] 扫雷游戏
 */

// @lc code=start
/**
 * @param {character[][]} board
 * @param {number[]} click
 * @return {character[][]}
 */
var updateBoard = function(board, click) {
    const dirX = [0, 1, 0, -1, 1, 1, -1, -1];
    const dirY = [1, 0, -1, 0, 1, -1, 1, -1];

    let dfs = function(board, x, y) {
        let cnt = 0;
        for (let i = 0; i < 8; i++) {
            const tx = x + dirX[i];
            const ty = y + dirY[i];
            if (tx < 0 || tx >= board.length || ty < 0 || ty >= board[0].length) {
                continue;
            }
            if (board[tx][ty] === 'M') {
                cnt++;
            }
        }
        if (cnt > 0) {
            board[x][y] = "" + cnt;
        } else {
            board[x][y] = 'B';
            for (let i = 0; i < 8; i++) {
                const tx = x + dirX[i];
                const ty = y + dirY[i];
                if (tx < 0 || tx >= board.length || ty < 0 || ty >= board[0].length || board[tx][ty] !== 'E') {
                    continue;
                }
                dfs(board, tx, ty);
            }
        }
    }

    const x = click[0], y = click[1];
    if (board[x][y] === 'M') {
        board[x][y] = 'X';
    } else {
        dfs(board, x, y);
    }
    return board;

};
// @lc code=end

