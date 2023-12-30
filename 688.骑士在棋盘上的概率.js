/*
 * @lc app=leetcode.cn id=688 lang=javascript
 *
 * [688] 骑士在棋盘上的概率
 */

// @lc code=start
/**
 * @param {number} n
 * @param {number} k
 * @param {number} row
 * @param {number} column
 * @return {number}
 */
var knightProbability = function(n, k, row, column) {

    let dp = Array.from({ length: n }, () => Array.from({ length: n }, () => Array.from({ length: k + 1 }, () => 0)));
    let moves = [[1, 2], [2, 1], [-1, 2], [2, -1], [1, -2], [-2, 1], [-1, -2], [-2, -1]];

    for (let kk = 0; kk <= k; kk++) {
        for (let i = 0; i < n; i++) {
            for (let j = 0; j < n; j++) {
                if (kk === 0) {
                    dp[i][j][kk] = 1;
                } else {
                    let p = 0;
                    for (let move of moves) {
                        let preI = i - move[0];
                        let preJ = j - move[1];

                        if (preI >=0 && preI < n && preJ >=0 && preJ < n) {
                            p += dp[preI][preJ][kk - 1];
                        }
                    }
                    dp[i][j][kk] = p/8;
                }
            }
        }
    }

    return dp[row][column][k];
};
// @lc code=end

