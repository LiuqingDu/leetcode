/*
 * @lc app=leetcode.cn id=405 lang=javascript
 *
 * [405] 数字转换为十六进制数
 */

// @lc code=start
/**
 * @param {number} num
 * @return {string}
 */
var toHex = function(num) {
    let arr = ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'];
    let res = [];
    if (num < 0) {
        num += Math.pow(2, 32);
    }
    while (num > 0) {
        let i = num % 16;
        res.push(arr[i]);
        num = Math.floor(num / 16);
    }
    if (res.length === 0) {
        res.push('0');
    }
    return res.reverse().join('');
};
// @lc code=end

