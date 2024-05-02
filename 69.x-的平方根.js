/*
 * @lc app=leetcode.cn id=69 lang=javascript
 *
 * [69] x 的平方根 
 */

// @lc code=start
/**
 * @param {number} x
 * @return {number}
 */
var mySqrt = function(x) {

    if (x <= 1) {
        return x;
    }

    let left = 1;
    let right = Math.floor(x / 2);
    while (left < right) {
        let mid = Math.floor(left + (right - left + 1) / 2);
        if (mid > Math.floor(x / mid)) {
            right = mid - 1;
        } else if (mid == Math.floor(x / mid)) {
            return mid;
        } else if (mid < Math.floor(x / mid)) {
            left = mid;
        }
    }
    
    return left;
};
// @lc code=end

