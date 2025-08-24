/*
 * @lc app=leetcode.cn id=2138 lang=javascript
 *
 * [2138] 将字符串拆分为若干长度为 k 的组
 */

// @lc code=start
/**
 * @param {string} s
 * @param {number} k
 * @param {character} fill
 * @return {string[]}
 */
var divideString = function(s, k, fill) {
    const n = s.length;
    const m = Math.ceil(n / k);
    const res = new Array(m).fill('');
    for (let i = 0; i < m; i++) {
        res[i] = s.slice(i * k, (i + 1) * k);
        if (res[i].length < k) {
            res[i] += fill.repeat(k - res[i].length);
        }
    }
    return res;
};
// @lc code=end

