/*
 * @lc app=leetcode.cn id=342 lang=javascript
 *
 * [342] 4的幂
 */

// @lc code=start
/**
 * @param {number} n
 * @return {boolean}
 */
var isPowerOfFour = function(n) {

    let sq = function(n) {
        let l = 0, r = n;
        while (l < r) {
            let mid = l + Math.floor((r - l) / 2);
            if (mid * mid >= n) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    if (n <= 0) {
        return false;
    }

    let x = sq(n);
    return x * x === n && (x & (x-1)) === 0;
};
// @lc code=end

