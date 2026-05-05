/*
 * @lc app=leetcode.cn id=1318 lang=javascript
 *
 * [1318] 或运算的最小翻转次数
 */

// @lc code=start
/**
 * @param {number} a
 * @param {number} b
 * @param {number} c
 * @return {number}
 */
var minFlips = function(a, b, c) {
    let ans = 0;

    for (let i = 0; i < 32; i++) {
        let bitA = (a >> i) & 1;
        let bitB = (b >> i) & 1;
        let bitC = (c >> i) & 1;

        if (bitC === 1) {
            if (bitA === 0 && bitB === 0) {
                ans += 1;
            }
        } else {
            if (bitA === 1 && bitB === 1) {
                ans += 2;
            } else if (bitA === 1 || bitB === 1) {
                ans += 1;
            }
        }
    }

    return ans;
};
// @lc code=end

