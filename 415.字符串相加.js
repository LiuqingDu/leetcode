/*
 * @lc app=leetcode.cn id=415 lang=javascript
 *
 * [415] 字符串相加
 */

// @lc code=start
/**
 * @param {string} num1
 * @param {string} num2
 * @return {string}
 */
var addStrings = function(num1, num2) {
    let x = num1.length - 1, y = num2.length - 1;
    let add = 0;
    let res = [];
    while (x >= 0 || y >= 0 || add !== 0) {
        let a = x >= 0 ? num1.charAt(x) - '0' : 0;
        let b = y >= 0 ? num2.charAt(y) - '0' : 0;
        let sum = a + b + add;
        res.push(sum % 10);
        add = Math.floor(sum / 10);
        x--;
        y--;
    }
    return res.reverse().join("");

};
// @lc code=end

