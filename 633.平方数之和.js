/*
 * @lc app=leetcode.cn id=633 lang=javascript
 *
 * [633] 平方数之和
 */

// @lc code=start
/**
 * @param {number} c
 * @return {boolean}
 */
var judgeSquareSum = function(c) {
    let left = 0;
    let right = Math.floor(Math.sqrt(c));
    while (left <= right) {
        let sum = left * left + right * right;
        if (sum === c) {
            return true;
        } else if (sum < c) {
            left++;
        } else {
            right--;
        }
    }
    return false;
};
// @lc code=end

