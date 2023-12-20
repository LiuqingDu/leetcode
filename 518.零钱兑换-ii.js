/*
 * @lc app=leetcode.cn id=518 lang=javascript
 *
 * [518] 零钱兑换 II
 */

// @lc code=start
/**
 * @param {number} amount
 * @param {number[]} coins
 * @return {number}
 */
var change = function(amount, coins) {

    // let res = 0;

    // let backtrace = function(amount, sum, cur, coins) {
    //     if (amount === sum) {
    //         res++;
    //         return;
    //     }

    //     for (let i = cur; i < coins.length; i++) {
    //         if (sum + coins[i] > amount) {
    //             break;
    //         }

    //         sum+=coins[i];
    //         backtrace(amount, sum, i, coins);
    //         sum-=coins[i];
            
    //     }
    // }

    // coins.sort((a, b) => a - b);

    // backtrace(amount, 0, 0, coins);

    // return res;

    let n = coins.length;

    let dp = Array.from(Array(n + 1), () => Array(amount + 1).fill(0));

    for (let i = 0; i <= n; i++) {
        dp[i][0] = 1;
    }

    for (let i = 1; i <= n; i++) {
        for (let j = 1; j <= amount; j++) {
            if (j - coins[i - 1] >= 0) {
                dp[i][j] = dp[i][j - coins[i - 1]] + dp[i - 1][j];
            } else {
                dp[i][j] = dp[i - 1][j];
            }
        }
    }

    return dp[n][amount];
};
// @lc code=end

