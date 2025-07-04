/*
 * @lc app=leetcode.cn id=1979 lang=javascript
 *
 * [1979] 找出数组的最大公约数
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var findGCD = function(nums) {
    let gcd = function(a, b) {
        if (b === 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    let min = Math.min(...nums);
    let max = Math.max(...nums);
    return gcd(min, max);
};
// @lc code=end

