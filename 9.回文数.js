/*
 * @lc app=leetcode.cn id=9 lang=javascript
 *
 * [9] 回文数
 */

// @lc code=start
/**
 * @param {number} x
 * @return {boolean}
 */
var isPalindrome = function(x) {

    let origin = x;

    if (x < 0) {
        return false;
    }

    let rev = 0;
    while (x !== 0) {
        let d = x % 10;
        rev = rev*10 + d;
        x = parseInt(x/10);
    }

    return rev === origin


};
// @lc code=end

