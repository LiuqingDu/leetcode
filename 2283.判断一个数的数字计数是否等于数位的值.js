/*
 * @lc app=leetcode.cn id=2283 lang=javascript
 *
 * [2283] 判断一个数的数字计数是否等于数位的值
 */

// @lc code=start
/**
 * @param {string} num
 * @return {boolean}
 */
var digitCount = function(num) {
    const count = new Array(10).fill(0);
    for (const char of num) {
        count[char.charCodeAt() - '0'.charCodeAt()]++;
    }
    for (let i = 0; i < num.length; i++) {
        if (count[i] !== (num[i].charCodeAt() - '0'.charCodeAt())) {
            return false;
        }
    }
    return true;
};
// @lc code=end

