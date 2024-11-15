/*
 * @lc app=leetcode.cn id=474 lang=javascript
 *
 * [474] 一和零
 */

// @lc code=start
/**
 * @param {string[]} strs
 * @param {number} m
 * @param {number} n
 * @return {number}
 */
var findMaxForm = function(strs, m, n) {
    let countZeroAndOne = function(str) {
        const cnt = [0, 0];
        for (const c of str) {
            cnt[c - '0']++;
        }
        return cnt;
    }
    
    const len = strs.length;
    const dp = Array.from({ length: len + 1 }, () => 
        Array.from({ length: m + 1 }, () => Array(n + 1).fill(0))
    );

    for (let i = 1; i <= len; i++) {
        const count = countZeroAndOne(strs[i - 1]);
        for (let j = 0; j <= m; j++) {
            for (let k = 0; k <= n; k++) {
                dp[i][j][k] = dp[i - 1][j][k];
                const zeros = count[0];
                const ones = count[1];
                if (j >= zeros && k >= ones) {
                    dp[i][j][k] = Math.max(dp[i - 1][j][k], dp[i - 1][j - zeros][k - ones] + 1);
                }
            }
        }
    }
    return dp[len][m][n];
};
// @lc code=end

