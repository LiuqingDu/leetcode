/*
 * @lc app=leetcode.cn id=174 lang=javascript
 *
 * [174] 地下城游戏
 */

// @lc code=start
/**
 * @param {number[][]} dungeon
 * @return {number}
 */
var calculateMinimumHP = function(dungeon) {

    let m = dungeon.length, n = dungeon[0].length;

    let dp = [];
    for (let i = 0; i <= m; i++) {
        dp[i] = [];
    }

    for (let i = m - 1; i >= 0; i--) {
        for (let j = n - 1; j >= 0; j--) {
            let min;
            if (i === m - 1 && j === n - 1) {
                min = 1 - dungeon[i][j];
            } else if (j === n - 1) {
                min = dp[i + 1][j] - dungeon[i][j];
            } else if (i === m - 1) {
                min = dp[i][j + 1] - dungeon[i][j];
            } else {
                min = Math.min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j];
            }
            
            dp[i][j] = Math.max(min, 1);
        }
    }

    return dp[0][0];

};
// @lc code=end

