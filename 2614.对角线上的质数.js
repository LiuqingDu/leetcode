/*
 * @lc app=leetcode.cn id=2614 lang=javascript
 *
 * [2614] 对角线上的质数
 */

// @lc code=start
/**
 * @param {number[][]} nums
 * @return {number}
 */
var diagonalPrime = function(nums) {
    
    var isPrime = function(num) {
        if (num === 1) {
            return false;
        }
        let factor = 2;
        while (factor * factor <= num) {
            if (num % factor === 0) {
                return false;
            }
            factor++;
        }
        return true;
    };
    
    let n = nums.length, res = 0;
    for (let i = 0; i < n; i++) {
        if (isPrime(nums[i][i])) {
            res = Math.max(res, nums[i][i]);
        }
        if (isPrime(nums[i][n - i - 1])) {
            res = Math.max(res, nums[i][n - i - 1]);
        }
    }
    return res;

};
// @lc code=end

