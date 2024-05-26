/*
 * @lc app=leetcode.cn id=202 lang=javascript
 *
 * [202] 快乐数
 */

// @lc code=start
/**
 * @param {number} n
 * @return {boolean}
 */
var isHappy = function(n) {
    let squareNum = function(n) {
        let res = 0;
        while (n > 0) {
            let bit = n % 10;
            res += bit * bit;
            n = Math.floor(n / 10);
        }
        return res;
    }

    let slow = n, fast = n;
    do {
        slow = squareNum(slow);
        fast = squareNum(squareNum(fast));
    } while (slow !== fast)

    return slow === 1;

};
// @lc code=end

