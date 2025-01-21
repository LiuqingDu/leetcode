/*
 * @lc app=leetcode.cn id=788 lang=javascript
 *
 * [788] 旋转数字
 */

// @lc code=start
/**
 * @param {number} n
 * @return {number}
 */
var rotatedDigits = function(n) {
    const check = [0, 0, 1, -1, -1, 1, 1, -1, 0, 1];
    let ans = 0;
    for (let i = 1; i <= n; ++i) {
        const num = '' + i;
        let valid = true, diff = false;
        for (let j = 0; j < num.length; ++j) {
            const ch = num[j];
            if (check[ch.charCodeAt() - '0'.charCodeAt()] === -1) {
                valid = false;
            } else if (check[ch.charCodeAt() - '0'.charCodeAt()] === 1) {
                diff = true;
            }
        }
        if (valid && diff) {
            ++ans;
        }
    }
    return ans;
};
// @lc code=end

