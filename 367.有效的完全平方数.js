/*
 * @lc app=leetcode.cn id=367 lang=javascript
 *
 * [367] 有效的完全平方数
 */

// @lc code=start
/**
 * @param {number} num
 * @return {boolean}
 */
var isPerfectSquare = function(num) {
    let l = 0, r = num;
    while (l <= r) {
        let mid = l + Math.floor((r - l) / 2);
        if (mid * mid < num) {
            l = mid + 1;
        } else if (mid * mid > num) {
            r = mid - 1;
        } else {
            return true;
        }
    }
    return false;

};
// @lc code=end

