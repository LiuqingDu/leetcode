/*
 * @lc app=leetcode.cn id=837 lang=javascript
 *
 * [837] 新 21 点
 */

// @lc code=start
/**
 * @param {number} n
 * @param {number} k
 * @param {number} maxPts
 * @return {number}
 */
var new21Game = function(n, k, maxPts) {
    
    const f = Array(n + 1).fill(0);
    let s = 0;
    for (let i = n; i >= 0; i--) {
        f[i] = i >= k ? 1 : s / maxPts;
        // 当前循环计算的是 f[i+1] + ... + f[i+maxPts]
        // 下个循环计算的是 f[i] + ... + f[i+maxPts-1]，多了 f[i]，少了 f[i+maxPts]
        s += f[i];
        if (i + maxPts <= n) {
            s -= f[i + maxPts];
        }
    }
    return f[0];

};
// @lc code=end

