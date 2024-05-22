/*
 * @lc app=leetcode.cn id=258 lang=javascript
 *
 * [258] 各位相加
 */

// @lc code=start
/**
 * @param {number} num
 * @return {number}
 */
var addDigits = function(num) {
    if (num < 10) {
        return num;
    }

    let nextNum = 0;
    while (num != 0) {
        nextNum = nextNum + (num % 10);
        num = Math.floor(num / 10);
    }

    return addDigits(nextNum);

};
// @lc code=end

