/*
 * @lc app=leetcode.cn id=868 lang=javascript
 *
 * [868] 二进制间距
 */

// @lc code=start
/**
 * @param {number} n
 * @return {number}
 */
var binaryGap = function(n) {
    let res = 0;
    for (let i = 31, j = -1; i >= 0; i--) {
        if (((n >> i) & 1) === 1) {
            if (j !== -1) {
                res = Math.max(res, j - i);
            }
            j = i;
        }
    }
    return res;
};
// @lc code=end

