/*
 * @lc app=leetcode.cn id=3079 lang=javascript
 *
 * [3079] 求出加密整数的和
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var sumOfEncryptedInt = function(nums) {
    let sum = 0;

    for (let num of nums) {
        let maxDigit = 0;
        let temp = num;

        // 1. 找最大数位
        while (temp > 0) {
            maxDigit = Math.max(maxDigit, temp % 10);
            temp = Math.floor(temp / 10);
        }

        // 2. 构造加密后的数
        let encrypted = 0;
        temp = num;

        while (temp > 0) {
            encrypted = encrypted * 10 + maxDigit;
            temp = Math.floor(temp / 10);
        }

        sum += encrypted;
    }

    return sum;
};
// @lc code=end

