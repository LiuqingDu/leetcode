/*
 * @lc app=leetcode.cn id=997 lang=javascript
 *
 * [997] 找到小镇的法官
 */

// @lc code=start
/**
 * @param {number} n
 * @param {number[][]} trust
 * @return {number}
 */
var findJudge = function(n, trust) {
    let out = Array(n + 1).fill(0);
    let inn = Array(n + 1).fill(0);

    for (let i = 0; i < trust.length; i++) {
        out[trust[i][0]]++;
        inn[trust[i][1]]++;
    }

    for (let i = 1; i <= n; i++) {
        if (out[i] === 0 && inn[i] === n - 1) {
            return i;
        }
    }

    return -1;
};
// @lc code=end

