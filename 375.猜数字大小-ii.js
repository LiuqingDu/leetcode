/*
 * @lc app=leetcode.cn id=375 lang=javascript
 *
 * [375] 猜数字大小 II
 */

// @lc code=start
/**
 * @param {number} n
 * @return {number}
 */
var getMoneyAmount = function(n) {

    // https://leetcode.cn/problems/guess-number-higher-or-lower-ii/solutions/83395/dong-tai-gui-hua-c-you-tu-jie-by-zhang-xiao-tong-2/

    if (n === 1) {
        return 0;
    }

    let dp = Array.from(new Array(n + 1), () => new Array(n + 1).fill(Number.MAX_VALUE));

    for (let i = 0; i <= n; i++) {
        dp[i][i] = 0;
    }

    for (let j = 2; j <= n; j++) {
        for (let i = j - 1; i >= 1; i--) {
            for (let k = i + 1; k <= j - 1; k++) {
                dp[i][j] = Math.min(k + Math.max(dp[i][k - 1], dp[k + 1][j]), dp[i][j]);
            }
            dp[i][j] = Math.min(dp[i][j], i + dp[i + 1][j]);
            dp[i][j] = Math.min(dp[i][j], j + dp[i][j - 1]);
        }
    }

    return dp[1][n];

};
// @lc code=end

