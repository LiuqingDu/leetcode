/*
 * @lc app=leetcode.cn id=2259 lang=javascript
 *
 * [2259] 移除指定数字得到的最大结果
 */

// @lc code=start
/**
 * @param {string} number
 * @param {character} digit
 * @return {string}
 */
var removeDigit = function(number, digit) {
    let n = number.length;
    let ind = -1;

    for (let i = 0; i < n; i++) {
        if (number[i] === digit) {
            ind = i;
            if (i < n - 1 && number[i + 1] > digit) {
                return number.slice(0, i) + number.slice(i + 1);
            }
        }
    }

    return number.slice(0, ind) + number.slice(ind + 1);
};
// @lc code=end

