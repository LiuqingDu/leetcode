/*
 * @lc app=leetcode.cn id=1550 lang=javascript
 *
 * [1550] 存在连续三个奇数的数组
 */

// @lc code=start
/**
 * @param {number[]} arr
 * @return {boolean}
 */
var threeConsecutiveOdds = function(arr) {
    let n = arr.length;
    let left = 0, right = 0;
    while (right < n) {
        if (arr[right] % 2 === 1) {
            if (right - left === 2) {
                return true;
            }
            right++;
        } else {
            right++;
            left = right;
        }
    }
    return false;
};
// @lc code=end

