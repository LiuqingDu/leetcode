/*
 * @lc app=leetcode.cn id=485 lang=javascript
 *
 * [485] 最大连续 1 的个数
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var findMaxConsecutiveOnes = function(nums) {
    let res = 0, count = 0;
    for (let i of nums) {
        if (i === 1) {
            count++;
        } else {
            res = Math.max(res, count);
            count = 0;
        }
    }

    res = Math.max(res, count);
    return res;

};
// @lc code=end

