/*
 * @lc app=leetcode.cn id=1758 lang=javascript
 *
 * [1758] 生成交替二进制字符串的最少操作数
 */

// @lc code=start
/**
 * @param {string} s
 * @return {number}
 */
var minOperations = function(s) {
    let cnt = 0;
    for (let i = 0; i < s.length; i++) {
        const c = s[i];
        if (c !== (String.fromCharCode('0'.charCodeAt() + i % 2))) {
            cnt++;
        }
    }
    return Math.min(cnt, s.length - cnt);
};
// @lc code=end

