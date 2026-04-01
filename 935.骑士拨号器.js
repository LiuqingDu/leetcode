/*
 * @lc app=leetcode.cn id=935 lang=javascript
 *
 * [935] 骑士拨号器
 */

// @lc code=start
/**
 * @param {number} n
 * @return {number}
 */
var knightDialer = function(n) {
    const MOD = 1_000_000_007;


    // 每个数字可以跳到哪些数字
    const moves = [
        [4, 6],    // 0
        [6, 8],    // 1
        [7, 9],    // 2
        [4, 8],    // 3
        [0, 3, 9], // 4
        [],        // 5
        [0, 1, 7], // 6
        [2, 6],    // 7
        [1, 3],    // 8
        [2, 4]     // 9
    ];

    // dp[i] 表示长度为当前步数的号码以数字 i 结尾的数量
    let dp = new Array(10).fill(1);

    for (let step = 2; step <= n; step++) {
        const next = new Array(10).fill(0);
        for (let num = 0; num <= 9; num++) {
            for (const jump of moves[num]) {
                next[num] = (next[num] + dp[jump]) % MOD;
            }
        }
        dp = next;
    }

    // 总和
    return dp.reduce((sum, count) => (sum + count) % MOD, 0);
};
// @lc code=end

