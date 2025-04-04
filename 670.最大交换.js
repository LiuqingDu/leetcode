/*
 * @lc app=leetcode.cn id=670 lang=javascript
 *
 * [670] 最大交换
 */

// @lc code=start
/**
 * @param {number} num
 * @return {number}
 */
var maximumSwap = function(num) {
    let digits = num.toString().split('');
    let last = new Array(10).fill(0);

    for (let i = 0; i < digits.length; i++) {
        last[digits[i]] = i;
    }

    for (let i = 0; i < digits.length; i++) {
        for (let d = 9; d > digits[i]; d--) {
            if (last[d] > i) {
                [digits[i], digits[last[d]]] = [digits[last[d]], digits[i]];
                return parseInt(digits.join(''));
            }
        }
    }

    return num;
};
// @lc code=end

