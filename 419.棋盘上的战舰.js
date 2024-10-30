/*
 * @lc app=leetcode.cn id=419 lang=javascript
 *
 * [419] 棋盘上的战舰
 */

// @lc code=start
/**
 * @param {character[][]} board
 * @return {number}
 */
var countBattleships = function(board) {
    let res = 0;
    let m = board.length;
    let n = board[0].length;

    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            if (board[i][j] === 'X') {
                if ((i === 0 || board[i - 1][j] === '.') 
                    && (j === 0 || board[i][j - 1] === '.')) {
                    res++;
                }
            }
        }
    }

    return res;
};
// @lc code=end

