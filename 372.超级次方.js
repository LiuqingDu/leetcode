/*
 * @lc app=leetcode.cn id=372 lang=javascript
 *
 * [372] 超级次方
 */

// @lc code=start
/**
 * @param {number} a
 * @param {number[]} b
 * @return {number}
 */
var superPow = function(a, b) {
    let MOD = 1337;

    let pow = function(a, b) {
        let res = 1;
        a %= MOD;
        while (b > 0) {
            res = res * a % MOD;
            b--;
        }
        return res;
    }

    let dfs = function(a, b, u) {
        if (u === -1) {
            return 1;
        }
        return pow(dfs(a, b, u - 1), 10) * pow(a, b[u]) % MOD;
    }

    return dfs(a, b, b.length - 1);
};
// @lc code=end

