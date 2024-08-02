/*
 * @lc app=leetcode.cn id=728 lang=javascript
 *
 * [728] 自除数
 */

// @lc code=start
/**
 * @param {number} left
 * @param {number} right
 * @return {number[]}
 */
var selfDividingNumbers = function(left, right) {
    let isDividing = function(num) {
        let tmp = num;
        while (tmp > 0) {
            let digit = tmp % 10;
            if (digit === 0 || num % digit !== 0) {
                return false;
            }
            tmp = Math.floor(tmp / 10);
        }
        return true;
    }

    let res = [];
    for (let i = left; i <= right; i++) {
        if (isDividing(i)) {
            res.push(i);
        }
    }
    return res;
};
// @lc code=end

