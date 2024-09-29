/*
 * @lc app=leetcode.cn id=29 lang=javascript
 *
 * [29] 两数相除
 */

// @lc code=start
/**
 * @param {number} dividend
 * @param {number} divisor
 * @return {number}
 */
var divide = function(dividend, divisor) {
    const MAX_VALUE = 2 ** 31 - 1, MIN_VALUE = -(2 ** 31);
    let quickAdd = function(y, z, x) {
        let result = 0, add = y;
        while (z !== 0) {
            if ((z & 1) !== 0) {
                if (result < x - add) {
                    return false;
                }
                result += add;
            }
            if (z !== 1) {
                if (add < x - add) {
                    return false;
                }
                add += add;
            }
            z >>= 1;
        }
        return true;
    }

    if (dividend === MIN_VALUE) {
        if (divisor === 1) {
            return MIN_VALUE;
        }
        if (divisor === -1) {
            return MAX_VALUE;
        }
    }
    if (divisor === MIN_VALUE) {
        return dividend === MIN_VALUE ? 1 : 0;
    }
    if (dividend === 0) {
        return 0;
    }
    
    let rev = false;
    if (dividend > 0) {
        dividend = -dividend;
        rev = !rev;
    }
    if (divisor > 0) {
        divisor = -divisor;
        rev = !rev;
    }
    
    let left = 1, right = MAX_VALUE, ans = 0;
    while (left <= right) {
        const mid = left + ((right - left) >> 1);
        const check = quickAdd(divisor, mid, dividend);
        if (check) {
            ans = mid;
            if (mid === MAX_VALUE) {
                break;
            }
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }
    return rev ? -ans : ans;
};
// @lc code=end

