/*
 * @lc app=leetcode.cn id=1071 lang=javascript
 *
 * [1071] 字符串的最大公因子
 */

// @lc code=start
/**
 * @param {string} str1
 * @param {string} str2
 * @return {string}
 */
var gcdOfStrings = function(str1, str2) {
    let gcd = function(a, b) {
        while (b !== 0) {
            let remainder = a % b;
            a = b;
            b = remainder;
        }
        return a;
    }
    
    if (str1 + str2 !== str2 + str1) {
        return "";
    }
    return str1.substring(0, gcd(str1.length, str2.length));
};
// @lc code=end

