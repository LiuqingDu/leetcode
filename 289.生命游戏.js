/*
 * @lc app=leetcode.cn id=289 lang=javascript
 *
 * [289] 生命游戏
 */

// @lc code=start
/**
 * @param {number[][]} board
 * @return {void} Do not return anything, modify board in-place instead.
 */
var gameOfLife = function(board) {

    // 自定义几个新状态，-1表示之前是活的，新状态是死的，
    // 2表示之前是死的，新状态是活的

    let m = board.length;
    let n = board[0].length;

    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            let live = 0;
            
            // 遍历周围8个格子，计算活的数量
            for (let offsetX = -1; offsetX <= 1; offsetX++) {
                for (let offsetY = -1; offsetY <= 1; offsetY++) {
                    // 两个offset均为0就是当前格子本身，应当跳过
                    if (!(offsetX === 0 && offsetY === 0)) {
                        let x = i + offsetX;
                        let y = j + offsetY;
                        // 这里判断要考虑到状态-1，这种本来是活的。
                        if (x >= 0 && x < m && y >= 0 && y < n && (board[x][y] === 1 || board[x][y] === -1)) {
                            live ++;
                        }
                    }
                }
            }

            if (board[i][j] === 1 && (live < 2 || live > 3)) {
                board[i][j] = -1;
            }
            if (board[i][j] === 0 && live === 3) {
                board[i][j] = 2;
            }
        }
    }

    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            if (board[i][j] >= 1) {
                board[i][j] = 1;
            }
            if (board[i][j] <= 0) {
                board[i][j] = 0;
            }
        }
    }

};
// @lc code=end

