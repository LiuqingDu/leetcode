/*
 * @lc app=leetcode.cn id=2180 lang=javascript
 *
 * [2180] 统计各位数字之和为偶数的整数个数
 */

// @lc code=start
/**
 * @param {number} num
 * @return {number}
 */
var countEven = function(num) {
    let count = 0;
    for (let i = 1; i <= num; i++) {
        if (isEven(i)) {
            count++;
        }
    }
    return count;
};

var isEven = function(n) {
    let sum = 0;
    while (n > 0) {
        sum += n % 10;
        n = Math.floor(n / 10);
    }
    return sum % 2 === 0;
};
// @lc code=end

