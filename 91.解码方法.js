/*
 * @lc app=leetcode.cn id=91 lang=javascript
 *
 * [91] 解码方法
 */

// @lc code=start
/**
 * @param {string} s
 * @return {number}
 */
var numDecodings = function(s) {

    let n = s.length;

    if (n === 0 || s.charAt(0) === '0') {
        return 0;
    }

    let dp = Array(n).fill(0);

    dp[0] = 1;
    
    for (let i = 1; i < n; i++) {
        if (s.charAt(i) > '0') {
            dp[i] = dp[i - 1];
        }
        if (s.charAt(i - 1) === '1' || (s.charAt(i - 1) === '2' && s.charAt(i) <= '6')) {
            if (i < 2) {
                dp[i] += 1;
            } else {
                dp[i] += dp[i - 2];
            }
        }
    }

    return dp[n - 1];

};
// @lc code=end

