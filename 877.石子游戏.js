/*
 * @lc app=leetcode.cn id=877 lang=javascript
 *
 * [877] 石子游戏
 */

// @lc code=start
/**
 * @param {number[]} piles
 * @return {boolean}
 */
var stoneGame = function(piles) {

    // alice always win.
    // return true;

    let n = piles.length;
    let dp = Array.from(Array(n), () => Array(n).fill(0));
    for (let i = 0; i < n; i++) {
        dp[i][i] =piles[i];
    }

    for (let i = 0; i < n - 1; i++) {
        for (let j = i + 1; j < n; j++) {
            dp[i][j] = Math.max(piles[i] - dp[i + 1][j], piles[j] - dp[i][j - 1]);
        }
    }

    return dp[0][n - 1] > 0;

};
// @lc code=end

